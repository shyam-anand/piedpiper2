package com.shyamanand.piedpiper.spotify.services;

import com.shyamanand.piedpiper.spotify.client.SpotifyClient;
import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;

/**
 *
 * @param <T> Implementation of {@link SpotifyRequest} class
 */
public abstract class SpotifyService {

  private final SpotifyClient spotifyClient;

  protected SpotifyService(SpotifyClient spotifyClient) {
    this.spotifyClient = spotifyClient;
  }

  protected SpotifyClient getSpotifyClient() {
    return spotifyClient;
  }

  public <R> R get(SpotifyRequest request, Class<R> resultType) {
    return spotifyClient.get(request, resultType);
  }
}
