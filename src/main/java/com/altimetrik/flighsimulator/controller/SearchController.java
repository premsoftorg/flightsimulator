package com.altimetrik.flighsimulator.controller;

import com.altimetrik.flighsimulator.entity.SearchRequest;
import com.altimetrik.flighsimulator.entity.SearchResponse;
import com.altimetrik.flighsimulator.service.SearchService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

  @Autowired
  private SearchService searchService;

  @GetMapping
  public SearchResponse searchFlights(@Valid SearchRequest request){
    return searchService.getSearchResults(request);
  }
}
