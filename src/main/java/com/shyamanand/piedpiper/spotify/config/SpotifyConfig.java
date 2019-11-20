package com.shyamanand.piedpiper.spotify.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpotifyConfig {

  @Value("${spotify.oauth-token}")
  private String oAuthToken;

  @Bean
  public String getOAuthToken() {
    return oAuthToken;
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
