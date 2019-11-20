package com.shyamanand.piedpiper.recommendations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

  private final RecommendationService recommendationService;

  @Autowired
  public RecommendationController(
      RecommendationService recommendationService) {
    this.recommendationService = recommendationService;
  }

  @GetMapping(value = "/recommendations", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity recommendations(@RequestParam("trackName") String trackName) {
    return ResponseEntity.ok(recommendationService.recommendations(trackName));
  }
}
