package com.shyamanand.piedpiper.spotify.services.artists;

import com.shyamanand.piedpiper.spotify.client.SpotifyClient;
import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;
import com.shyamanand.piedpiper.spotify.services.SpotifyService;
import org.springframework.stereotype.Service;

@Service
public class ArtistsService extends SpotifyService {

  protected ArtistsService(
      SpotifyClient spotifyClient) {
    super(spotifyClient);
  }

  public SimilarArtistsResponse similarArtists(String artistId) {
    SimilarArtistRequest request = new SimilarArtistRequest();
    request.setArtistId(artistId);
    return getSpotifyClient().get(request, SimilarArtistsResponse.class);
  }

  public TopTracksResponse topTracks(String artistId) {
    TopTracksRequest request = new TopTracksRequest();
    request.setArtistId(artistId);
    return getSpotifyClient().get(request, TopTracksResponse.class);
  }
}
