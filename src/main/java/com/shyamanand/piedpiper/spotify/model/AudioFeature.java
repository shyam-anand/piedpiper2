package com.shyamanand.piedpiper.spotify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioFeature extends SpotifyObject {

  private int duration_ms;
  private Mode mode;
  @JsonProperty("time_signature")
  private int timeSignature;

  private float acousticness;
  private float danceability;
  private float energy;
  private float instrumentalness;
  private float liveness;
  private float loudness;
  private float speechiness;
  private float tempo;
  private float valence;

  private enum  Mode {
    MINOR, MAJOR;
  }

}
