package com.shyamanand.piedpiper.spotify.model;

public enum AlbumType {
  ALBUM("album"), SINGLE("single"), COMPILATION("compilation");

  private final String type;

  AlbumType(String type) {
    this.type = type;
  }
}
