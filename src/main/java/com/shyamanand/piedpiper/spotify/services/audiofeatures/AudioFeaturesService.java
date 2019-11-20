package com.shyamanand.piedpiper.spotify.services.audiofeatures;

import com.shyamanand.piedpiper.spotify.client.SpotifyClient;
import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;
import com.shyamanand.piedpiper.spotify.model.AudioFeature;
import com.shyamanand.piedpiper.spotify.services.SpotifyService;
import org.springframework.stereotype.Service;

@Service
public class AudioFeaturesService extends SpotifyService {

  protected AudioFeaturesService(
      SpotifyClient spotifyClient) {
    super(spotifyClient);
  }

  public AudioFeature audioFeature(String trackId) {

    AudioFeaturesRequest request = new AudioFeaturesRequest();
    request.setTrackId(trackId);
    return getSpotifyClient().get(request, AudioFeature.class);
  }
}
