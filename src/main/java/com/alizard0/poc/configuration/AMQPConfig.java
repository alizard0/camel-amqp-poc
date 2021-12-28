package com.alizard0.poc.configuration;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {

  @Bean
  AMQPConnectionDetails amqpConnectionDetails() {
    return new AMQPConnectionDetails("amqp://localhost:5672");
  }
}
