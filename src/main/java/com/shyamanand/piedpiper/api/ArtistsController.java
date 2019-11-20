package com.shyamanand.piedpiper.api;

import com.shyamanand.piedpiper.spotify.services.artists.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistsController {

  private final ArtistsService artistsService;

  @Autowired
  public ArtistsController(ArtistsService artistsService) {
    this.artistsService = artistsService;
  }

  @GetMapping("/artists/{artistId}/similar")
  public ResponseEntity similarArtists(@PathVariable("artistId") String artistId) {
    return ResponseEntity.ok(artistsService.similarArtists(artistId));
  }

  @GetMapping("/artists/{artistId}/top-tracks")
  public ResponseEntity topTracks(@PathVariable("artistId") String artistId) {
    return ResponseEntity.ok(artistsService.topTracks(artistId));
  }
}
