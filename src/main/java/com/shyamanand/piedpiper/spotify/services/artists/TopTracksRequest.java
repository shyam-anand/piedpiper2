package com.shyamanand.piedpiper.spotify.services.artists;

import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;
import java.util.Map;

public class TopTracksRequest extends SpotifyRequest {

  private static final String ENDPOINT = "/artists/%s/top-tracks?country={country}";

  public void setArtistId(String artistId) {
    this.artistId = artistId;
  }

  private String artistId;

  @Override
  public Map<String, Object> getQueryParams() {
    queryParams.put("artistId", artistId);
    queryParams.put("country", "US"); // FIXME -- hardcoded
    setEndpoint(String.format(ENDPOINT, artistId));
    return queryParams;
  }
}
