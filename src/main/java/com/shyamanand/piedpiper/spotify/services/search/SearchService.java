package com.shyamanand.piedpiper.spotify.services.search;

import com.shyamanand.piedpiper.spotify.client.SpotifyClient;
import com.shyamanand.piedpiper.spotify.model.ObjectType;
import com.shyamanand.piedpiper.spotify.services.SpotifyService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService extends SpotifyService<SearchRequest> {

  @Autowired
  protected SearchService(SpotifyClient spotifyClient) {
    super(spotifyClient);
  }

  public SearchResult searchForTrack(String trackName) {
    SearchRequest searchRequest = new SearchRequest();
    searchRequest.setQuery(trackName);
    searchRequest.setType(ObjectType.TRACK);
    searchRequest.setLimit(1);
    Map<String, SearchResult> searchResult = (Map<String, SearchResult>) get(searchRequest, Map.class);
    return searchResult.get("tracks");
  }
}
