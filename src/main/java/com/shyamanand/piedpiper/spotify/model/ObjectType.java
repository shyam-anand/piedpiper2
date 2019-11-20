package com.shyamanand.piedpiper.spotify.model;

public enum ObjectType {
  ALBUM("album"), TRACK("track");

  private final String type;

  ObjectType(String type) {
    this.type = type;
  }
}
