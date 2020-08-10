package com.altimetrik.flighsimulator.microservicecontroller;

import com.altimetrik.flighsimulator.entity.SearchRequest;
import com.altimetrik.flighsimulator.entity.SearchResponse;

public interface AirlinesController {
  SearchResponse getFlightResults(SearchRequest searchRequest);
}
