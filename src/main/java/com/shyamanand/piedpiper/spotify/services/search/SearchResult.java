package com.shyamanand.piedpiper.spotify.services.search;

import com.shyamanand.piedpiper.spotify.model.Track;
import java.util.Collection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// ToDo
@Getter
@Setter
@NoArgsConstructor
public class SearchResult {

  private Collection<Track> items;
  private int limit;
  private String next;
  private int offset;
  private int total;
}
