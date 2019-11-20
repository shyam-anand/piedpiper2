package com.shyamanand.piedpiper.spotify.services.artists;

import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;
import java.util.HashMap;
import java.util.Map;

public class SimilarArtistRequest extends SpotifyRequest {

  private static final String endpoint = "/artists/%s/related-artists";
  private String artistId;

  protected SimilarArtistRequest() {}

  @Override
  public Map<String, Object> getQueryParams() {
    Map<String, Object> queryParams = new HashMap<>();
    queryParams.put("artistId", artistId);
    setEndpoint(String.format(endpoint, artistId));
    return queryParams;
  }

  public void setArtistId(String artistId) {
    this.artistId = artistId;
  }
}
