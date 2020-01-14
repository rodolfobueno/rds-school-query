package br.com.rdschool.query;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RDSExchange {

	public static final String INPUT = "rds-input-events";
	
	@Input(RDSExchange.INPUT)
	SubscribableChannel input();
}
