package com.shyamanand.piedpiper.spotify.client;

import java.util.Collections;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class SpotifyClient {

  private final RestTemplate restTemplate;

  // ToDo Write to DB / Create auth service
  private static final String TOKEN =
      "BQAhoEKvvBL6V91sKZF6RdFiMdo0JHNMT4e2LwgGJZOiSph-DWu35K-wQuw5pCpqneobIx66uD5UFpcbfZgcDPPdIQUFFMkX1kNe2LkTTv2Hmiml_yXArd-vuD4M6hzrR5Ey5JJYl0vr";

  //  ToDo Move to properties file
  private static final String API_URL = "https://api.spotify.com/v1";

  @Autowired
  public SpotifyClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public <T> T get(SpotifyRequest request, Class<T> responseType) {
    Map<String, ?> uriVars = request.getQueryParams();
    log.info("uriVars = {}", uriVars);
    String url = getUrl(request);
    log.info("url = {}", url);
    ResponseEntity<T> responseEntity =
        restTemplate.exchange(
            url, HttpMethod.GET, requestEntity(), responseType, uriVars);

    log.info("Response: {}", responseEntity.getStatusCode());
    if (responseEntity.getStatusCode().is2xxSuccessful()) {
      if (responseEntity.getBody() == null) {
        log.info("Response body is null");
      } else {
        log.info("Response body type = {}", responseEntity.getBody().getClass());
      }
      return responseEntity.getBody();
    } else {
      throw new RuntimeException(responseEntity.getStatusCode().getReasonPhrase());
    }
  }

  private HttpEntity<String> requestEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.add("Authorization", "Bearer " + TOKEN);
    return new HttpEntity<>(headers);
  }

  private String getUrl(SpotifyRequest request) {
    return API_URL + request.getEndpoint();
  }
}
