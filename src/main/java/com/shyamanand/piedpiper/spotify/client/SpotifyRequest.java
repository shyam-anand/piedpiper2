package com.shyamanand.piedpiper.spotify.client;

import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class SpotifyRequest {

  private String endpoint;
  protected HashMap<String, Object> queryParams = new HashMap<>();

  protected SpotifyRequest(String endpoint) {
    this.endpoint = endpoint;
  }

  public abstract Map<String, Object> getQueryParams();

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }
}
