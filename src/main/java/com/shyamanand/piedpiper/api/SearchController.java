package com.shyamanand.piedpiper.api;

import com.shyamanand.piedpiper.spotify.services.search.SearchResult;
import com.shyamanand.piedpiper.spotify.services.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SearchController {

  private final SearchService searchService;

  @Autowired
  public SearchController(
      SearchService searchService) {
    this.searchService = searchService;
  }

  @GetMapping(value = "/tracks", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity search(@RequestParam("q") String query) {
    SearchResult searchResult = searchService.searchForTrack(query);
    log.info("searchResult={}", searchResult);
    return ResponseEntity.ok(searchResult);
  }

}
