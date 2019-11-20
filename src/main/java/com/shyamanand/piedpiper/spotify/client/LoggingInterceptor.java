package com.shyamanand.piedpiper.spotify.client;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

@Log4j2
public class LoggingInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(
      HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    logRequest(request, body);
    ClientHttpResponse response = execution.execute(request, body);
    logResponse(response);
    return response;
  }

  private void logRequest(HttpRequest request, byte[] body) {
    log.info(
        "Request URI: {}, Headers: {}, Request Body: {} ",
        request.getURI(),
        request.getHeaders(),
        new String(body, StandardCharsets.UTF_8));
  }

  private void logResponse(ClientHttpResponse response) throws IOException {
    log.info(
        "Response status code: {}, Response body: {}",
        response.getStatusCode(),
        StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
  }
}