package com.shyamanand.piedpiper.recommendations;

import com.shyamanand.piedpiper.spotify.model.AudioFeature;
import com.shyamanand.piedpiper.spotify.model.SpotifyObject;
import com.shyamanand.piedpiper.spotify.model.Track;
import com.shyamanand.piedpiper.spotify.services.artists.ArtistsService;
import com.shyamanand.piedpiper.spotify.services.artists.TopTracksResponse;
import com.shyamanand.piedpiper.spotify.services.audiofeatures.AudioFeaturesService;
import com.shyamanand.piedpiper.spotify.services.search.SearchResult;
import com.shyamanand.piedpiper.spotify.services.search.SearchService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecommendationService {

  private final SearchService searchService;
  private final AudioFeaturesService audioFeaturesService;
  private final ArtistsService artistsService;

  @Autowired
  public RecommendationService(
      SearchService searchService,
      AudioFeaturesService audioFeaturesService,
      ArtistsService artistsService) {
    this.searchService = searchService;
    this.audioFeaturesService = audioFeaturesService;
    this.artistsService = artistsService;
  }

  public Collection<String> recommendations(String trackName) {
    SearchResult searchResult = searchService.searchForTrack(trackName);
    if (searchResult.getItems().isEmpty()) {
      log.info("No search results for {}", trackName);
      return Collections.emptySet();
    }

    ArrayList<Track> tracks = new ArrayList<>(searchResult.getItems());
    Track firstTrack = tracks.get(0);
    return recommendations(firstTrack);
  }

  public Collection<String> recommendations(Track track) {
    Map<String, Float> similarTracks = new HashMap<>();
    AudioFeature audioFeature = audioFeaturesService.audioFeature(track.getId());
    track.getArtists().stream()
        .findFirst()
        .map(SpotifyObject::getId)
        .map(artistsService::topTracks)
        .map(TopTracksResponse::getTracks)
        .map(
            tracks -> {
              Map<String, AudioFeature> trackAudioFeature =
                  tracks.stream()
                      .map(SpotifyObject::getId)
                      .collect(Collectors.toMap(tId -> tId, audioFeaturesService::audioFeature));
              return trackAudioFeature;
            })
        .ifPresent(
            trackAudioFeatureMap -> {
              trackAudioFeatureMap.forEach(
                  (trackName, tAudioFeature) -> {
                    float similarity = similarity(tAudioFeature, audioFeature);
                    if (similarity <= .1) {
                      similarTracks.put(trackName, similarity);
                    }
                  });
            });
    Set<String> recos = new TreeSet<>((o1, o2) -> {
      float d = similarTracks.get(o1) - similarTracks.get(o2);
      return d == 0 ? 0 : (d >= 1.0) ? 1 : -1;
    });
    recos.addAll(similarTracks.keySet());
    return recos;
  }

  //ToDo Compare more audio features
  private float similarity(AudioFeature tAudioFeature, AudioFeature audioFeature) {
    return
        audioFeature.getValence() > tAudioFeature.getValence()
            ? audioFeature.getValence() - tAudioFeature.getValence()
            : tAudioFeature.getValence() - audioFeature.getValence();
  }
}
