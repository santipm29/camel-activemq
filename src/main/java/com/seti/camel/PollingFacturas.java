package com.seti.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PollingFacturas extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("timer://polling?period=1000")
		.setBody()
		.simple("Hello World Camel fired at ${header.firedTime}")
		//.log("executed")
		.to("activemq:hola");		
		
		from("activemq:hola")
		.to("log:prueba");
	}

}
