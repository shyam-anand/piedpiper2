package com.shyamanand.piedpiper.spotify.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyClient {

  private final RestTemplate restTemplate;

  @Autowired
  public SpotifyClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


}
