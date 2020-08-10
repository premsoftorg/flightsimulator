package com.altimetrik.flighsimulator.service;

import com.altimetrik.flighsimulator.entity.SearchRequest;
import com.altimetrik.flighsimulator.entity.SearchResponse;

public interface SearchService {
    SearchResponse getSearchResults(SearchRequest request);
}
