package com.shyamanand.piedpiper.spotify.model;

public enum AlbumGroup {
  
  ALBUM("album"), SINGLE("single"), COMPILATION("compilation"), APPEARS_ON("appears_on");

  private final String value;

  AlbumGroup(String value) {
    this.value = value;
  }
}
