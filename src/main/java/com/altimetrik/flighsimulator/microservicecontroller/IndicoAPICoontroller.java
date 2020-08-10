package com.altimetrik.flighsimulator.microservicecontroller;

import com.altimetrik.flighsimulator.SimulateRestTemplate;
import com.altimetrik.flighsimulator.entity.SearchRequest;
import com.altimetrik.flighsimulator.entity.SearchResponse;
import org.springframework.stereotype.Component;

@Component
public class IndicoAPICoontroller implements AirlinesController {

  public String getUrl() {
    return url;
  }

  String url = "https://indico-api:80/";

  @Override
  public SearchResponse getFlightResults(SearchRequest searchRequest) {
    return new SimulateRestTemplate().exchange(url,searchRequest);
  }
}
