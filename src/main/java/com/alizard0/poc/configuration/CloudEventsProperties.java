package com.alizard0.poc.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "cloudevents")
@Configuration
public class CloudEventsProperties {
  private String specVersion;
  private String source;
  private String type;
  private String dataSchema;
  private String subject;
  private String keyType;
  private String keySchema;
}