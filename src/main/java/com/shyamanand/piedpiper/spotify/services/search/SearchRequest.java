package com.shyamanand.piedpiper.spotify.services.search;

import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;
import com.shyamanand.piedpiper.spotify.model.ObjectType;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchRequest extends SpotifyRequest {
  private ObjectType type;
  private String query;

  @Override
  public Map<String, Object> getQueryParams() {
    Map<String, Object> queryParams = new HashMap<>();
    queryParams.put("q", query);
    queryParams.put("type", type);

    // ToDo -- limit and offset

    return queryParams;
  }
}
