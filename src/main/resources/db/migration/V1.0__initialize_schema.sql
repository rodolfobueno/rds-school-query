CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE turma
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default" NOT NULL,
    ano_letivo integer NOT NULL,
    periodo_letivo integer NOT NULL,
    numero_vagas integer NOT NULL,
    CONSTRAINT turma_pkey PRIMARY KEY (id)
);
