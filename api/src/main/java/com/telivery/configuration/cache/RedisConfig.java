package com.telivery.configuration.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

  @Value("${spring.redis.port}")
  public int port;

  @Value("${spring.redis.host}")
  public String host;

  @Autowired
  public ObjectMapper objectMapper;

}
