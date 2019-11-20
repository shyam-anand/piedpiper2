package com.shyamanand.piedpiper.spotify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Collection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album extends SpotifyObject {

  @JsonProperty("album_group")
  private AlbumGroup albumGroup;

  private AlbumType albumType;
  private Collection<Artist> artists;

  @JsonSetter
  @JsonProperty("album_type")
  public void setAlbumType(String type) {
    this.albumType = AlbumType.fromString(type);
  }

}
