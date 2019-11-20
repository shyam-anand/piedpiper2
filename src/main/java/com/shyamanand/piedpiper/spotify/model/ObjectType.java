package com.shyamanand.piedpiper.spotify.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ObjectType {

  @JsonProperty("album")
  ALBUM("album"),
  @JsonProperty("track")
  TRACK("track"),
  @JsonProperty("artist")
  ARTIST("artist");

  private final String type;

  ObjectType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
