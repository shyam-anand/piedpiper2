package com.shyamanand.piedpiper.spotify.services.search;

import com.shyamanand.piedpiper.spotify.client.SpotifyRequest;
import com.shyamanand.piedpiper.spotify.model.ObjectType;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest extends SpotifyRequest {
  private static final String ENDPOINT = "/search?q={q}&type={type}&limit={limit}";
  private ObjectType type;
  private String query;
  private int limit;

  public SearchRequest() {
    super(ENDPOINT);
  }

  @Override
  public Map<String, Object> getQueryParams() {
    Map<String, Object> queryParams = new HashMap<>();
    queryParams.put("q", query);
    queryParams.put("type", type.getType());
    queryParams.put("limit", limit);

    // ToDo -- offset

    return queryParams;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getLimit() {
    return limit;
  }
}
