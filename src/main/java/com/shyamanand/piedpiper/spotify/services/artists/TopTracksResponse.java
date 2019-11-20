package com.shyamanand.piedpiper.spotify.services.artists;

import com.shyamanand.piedpiper.spotify.model.Track;
import java.util.Collection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TopTracksResponse {

  private Collection<Track> tracks;
}
