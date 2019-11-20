package com.shyamanand.piedpiper.spotify.config;

import com.shyamanand.piedpiper.spotify.client.LoggingInterceptor;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpotifyConfig {

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setInterceptors(Arrays.asList(new LoggingInterceptor()));
    return restTemplate;
  }
}
