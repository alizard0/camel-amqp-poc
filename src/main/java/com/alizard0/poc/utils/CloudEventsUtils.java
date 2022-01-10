package com.alizard0.poc.utils;

import com.alizard0.poc.configuration.CloudEventsProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CloudEventsUtils {
  private static final String PREFIX = "cloudEvents:";
  private static final String SPEC_VERSION= PREFIX + "specversion";
  private static final String ID = PREFIX + "id";
  private static final String TYPE = PREFIX + "type";
  private static final String SOURCE = PREFIX + "source";
  private static final String APPLICATION_AVRO = PREFIX + "application/avro";
  private static final String CONTENT_TYPE = PREFIX + "content-type";

  public static Map<String, String> getHeaders(CloudEventsProperties properties) {
    final Map<String, String> headers = new HashMap<>();
    headers.put(SPEC_VERSION, properties.getSpecVersion());
    headers.put(ID, UUID.randomUUID().toString());
    headers.put(TYPE, properties.getType());
    headers.put(SOURCE, properties.getSource());
    headers.put(CONTENT_TYPE, APPLICATION_AVRO);
    return headers;
  }
}
