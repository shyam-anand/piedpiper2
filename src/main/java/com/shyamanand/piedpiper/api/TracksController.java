package com.shyamanand.piedpiper.api;

import com.shyamanand.piedpiper.spotify.services.audiofeatures.AudioFeaturesService;
import com.shyamanand.piedpiper.spotify.services.search.SearchResult;
import com.shyamanand.piedpiper.spotify.services.search.SearchService;
import javax.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/tracks")
public class TracksController {

  private final SearchService searchService;
  private final AudioFeaturesService audioFeaturesService;

  @Autowired
  public TracksController(
      SearchService searchService,
      AudioFeaturesService audioFeaturesService) {
    this.searchService = searchService;
    this.audioFeaturesService = audioFeaturesService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity search(@RequestParam("q") String query) {
    SearchResult searchResult = searchService.searchForTrack(query);
    log.info("searchResult={}", searchResult);
    return ResponseEntity.ok(searchResult);
  }

  @GetMapping(value = "/{trackId}/audio-features", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity audioFeatures(@PathVariable("trackId") String trackId) {
    return ResponseEntity.ok(audioFeaturesService.audioFeature(trackId));
  }
}
