package com.shyamanand.piedpiper.spotify.client;

import java.util.Map;

public abstract class SpotifyRequest {

  private final String endpoint;

  protected SpotifyRequest(String endpoint) {
    this.endpoint = endpoint;
  }

  public abstract Map<String, Object> getQueryParams();

  public String getEndpoint() {
    return endpoint;
  }
}
