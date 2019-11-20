package com.shyamanand.piedpiper.spotify.services;

import com.shyamanand.piedpiper.spotify.client.SpotifyClient;
import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;

/**
 *
 * @param <T> Implementation of {@link SpotifyRequest} class
 * @param <R> Type for Result
 */
public abstract class SpotifyService<T extends SpotifyRequest, R> {

  private final SpotifyClient spotifyClient;

  protected SpotifyService(SpotifyClient spotifyClient) {
    this.spotifyClient = spotifyClient;
  }

  protected SpotifyClient getSpotifyClient() {
    return spotifyClient;
  }

  public abstract R get(T request);
}
