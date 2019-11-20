package com.shyamanand.piedpiper.spotify.services.search;

import com.shyamanand.piedpiper.spotify.client.SpotifyClient;
import com.shyamanand.piedpiper.spotify.services.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService extends SpotifyService<SearchRequest, SearchResult> {

  @Autowired
  protected SearchService(SpotifyClient spotifyClient) {
    super(spotifyClient);
  }

  @Override
  public SearchResult get(SearchRequest request) {
    return null;
  }
}
