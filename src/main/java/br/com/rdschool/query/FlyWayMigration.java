package br.com.rdschool.query;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class FlyWayMigration implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DataSource dataSource;
    final transient Logger log = LoggerFactory.getLogger(FlyWayMigration.class);

    @Autowired
    private FlyWayProperties properties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (properties.isMigrate()) {
            log.info("Migrate is enabled");
            var schemas = properties.getSchemas().replace(" ", "").split(",");
            log.info(new StringBuilder().append("Configured schemas for migration:").append(String.join(",", schemas))
                    .toString());
            if (properties.getLocations() != null) {
                log.info(new StringBuilder().append("Scripts locations:").append(properties.getLocations()).toString());
            }
            for (var schema : schemas) {
                var createSchema = (schema.toLowerCase().equals("public")) ? "public"
                        : "_" + schema.toUpperCase().replace("-", "_");
                var flyway = Flyway.configure().baselineOnMigrate(properties.isBaselineOnMigrate())
                        .dataSource(dataSource).schemas(createSchema);
                if (properties.getLocations() != null) {
                    flyway = flyway.locations(properties.getLocations());
                }
                flyway.load().migrate();

            }
        }
    }
}
