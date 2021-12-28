package com.alizard0.poc.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class ServiceRoute extends RouteBuilder {

  @Override
  public void configure() {
    restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.auto)
            .dataFormatProperty("prettyPrint", "true");

    rest("/event")
            .post()
              .id("publishEventServletRoute")
              .to("direct:publishEvent");
  }
}
