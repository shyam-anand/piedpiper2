package com.shyamanand.piedpiper.spotify.services.artists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shyamanand.piedpiper.spotify.model.Artist;
import java.util.Collection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimilarArtistsResponse {

  private Collection<Artist> artists;
}
