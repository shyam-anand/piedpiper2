package com.shyamanand.piedpiper.spotify.services.audiofeatures;

import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;
import java.util.Map;

public class AudioFeaturesRequest extends SpotifyRequest {

  private static final String ENDPOINT = "/audio-features?ids={trackId}";

  public AudioFeaturesRequest() {
    super(ENDPOINT);
  }

  public String getTrackId() {
    return trackId;
  }

  public void setTrackId(String trackId) {
    this.trackId = trackId;
  }

  private String trackId;

  @Override
  public Map<String, Object> getQueryParams() {
    queryParams.put("trackId", trackId);
    return queryParams;
  }
}
