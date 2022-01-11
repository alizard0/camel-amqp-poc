package com.alizard0.poc.route;

import com.alizard0.poc.configuration.CloudEventsProperties;
import com.alizard0.poc.utils.CloudEventsUtils;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PublishEventRoute extends RouteBuilder {
  private CloudEventsProperties properties;

  public PublishEventRoute (CloudEventsProperties properties) {
    this.properties = properties;
  }

  @Override
  public void configure() {
    from("direct:publishEvent")
            .id("publishEventDirectRoute")
            .log("Publishing event ${body}")
            // disabling cloudevents on amqp because JMS does not support it
            //.process(exchange -> exchange.getIn().getHeaders().putAll(CloudEventsUtils.getHeaders(properties)))
            .to(ExchangePattern.InOnly,"amqp:queue:events")
            .end();
  }
}
