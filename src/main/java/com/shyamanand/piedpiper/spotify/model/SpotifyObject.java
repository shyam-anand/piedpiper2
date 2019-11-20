package com.shyamanand.piedpiper.spotify.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = "id")
public class SpotifyObject {

  private String id;
  private String name;
  private ObjectType type;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ObjectType getType() {
    return type;
  }

  public void setType(ObjectType type) {
    this.type = type;
  }
}
