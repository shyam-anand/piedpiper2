package com.shyamanand.piedpiper.spotify.client;

import java.util.Map;

public abstract class SpotifyRequest {

  public abstract Map<String, Object> getQueryParams();
}
