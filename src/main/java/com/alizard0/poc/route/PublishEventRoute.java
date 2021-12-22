package com.alizard0.poc.route;

import com.alizard0.poc.dto.PostEventRequest;
import com.alizard0.poc.dto.PostEventResponse;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestOperationResponseMsgDefinition;
import org.springframework.stereotype.Component;

@Component
public class PublishEventRoute extends RouteBuilder {

  @Override
  public void configure() {
    restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.auto);

    rest()
          .path("/event")
          .consumes("application/json")
          .produces("application/json")
          .get()
            .responseMessage(new RestOperationResponseMsgDefinition())
          .post()
            .type(PostEventRequest.class)
            .outType(PostEventResponse.class)
            .to("amqp:topic:events");
  }
}
