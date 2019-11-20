package com.shyamanand.piedpiper.spotify.services.search;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shyamanand.piedpiper.spotify.client.SpotifyClient;
import com.shyamanand.piedpiper.spotify.model.ObjectType;
import com.shyamanand.piedpiper.spotify.services.SpotifyService;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService extends SpotifyService {

  @Autowired
  protected SearchService(SpotifyClient spotifyClient) {
    super(spotifyClient);
  }

  public SearchResult searchForTrack(String trackName) {
    SearchRequest searchRequest = new SearchRequest();
    searchRequest.setQuery(trackName);
    searchRequest.setType(ObjectType.TRACK);
    searchRequest.setLimit(1);
    return Optional.ofNullable(get(searchRequest, JsonNode.class))
        .map(responseJson -> new ObjectMapper().convertValue(responseJson.get("tracks"), SearchResult.class))
        .orElse(null);
  }
}
