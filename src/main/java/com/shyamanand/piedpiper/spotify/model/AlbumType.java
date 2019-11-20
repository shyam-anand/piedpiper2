package com.shyamanand.piedpiper.spotify.model;

import java.util.stream.Stream;

public enum AlbumType {
  ALBUM("album"), SINGLE("single"), COMPILATION("compilation");

  private final String type;

  AlbumType(String type) {
    this.type = type;
  }

  public static AlbumType fromString(String type) {
    return Stream.of(values())
        .filter(albumType -> albumType.type.equals(type))
        .findAny()
        .orElse(null);
  }
}
