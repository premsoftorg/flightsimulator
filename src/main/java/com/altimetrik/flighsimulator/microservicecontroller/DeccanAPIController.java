package com.altimetrik.flighsimulator.microservicecontroller;

import com.altimetrik.flighsimulator.SimulateRestTemplate;
import com.altimetrik.flighsimulator.entity.SearchRequest;
import com.altimetrik.flighsimulator.entity.SearchResponse;
import org.springframework.stereotype.Service;

@Service
public class DeccanAPIController implements  AirlinesController {

  String url = "https://deccan-api:80/";

  public String getUrl() {
    return url;
  }

  @Override
  public SearchResponse getFlightResults(SearchRequest searchRequest) {
    return new SimulateRestTemplate().exchange(url,searchRequest);
  }
}
