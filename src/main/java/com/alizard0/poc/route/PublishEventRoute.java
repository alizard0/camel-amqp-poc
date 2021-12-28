package com.alizard0.poc.route;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PublishEventRoute extends RouteBuilder {

  @Override
  public void configure() {
    from("direct:publishEvent")
            .id("publishEventDirectRoute")
            .log("Publishing event ${body}")
            .to(ExchangePattern.InOnly,"amqp:queue:events")
            .end();
  }
}
