package com.altimetrik.flighsimulator.service.Impl;

import com.altimetrik.flighsimulator.entity.FlightEntity;
import com.altimetrik.flighsimulator.entity.SearchRequest;
import com.altimetrik.flighsimulator.entity.SearchResponse;
import com.altimetrik.flighsimulator.exceptions.PastDateValidationException;
import com.altimetrik.flighsimulator.microservicecontroller.AirlinesController;
import com.altimetrik.flighsimulator.service.SearchService;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class )
@SpringBootTest
public class SearchServiceImplTest {

  private static Random rand = new Random();
  private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Autowired
  private SearchService searchService;

  @Test
  public void getSearchResultsSuccesswithreturndatenull() {
    SearchRequest searchRequest = new SearchRequest("Chennai","oimbatore",
        new Date(new Date().getTime() + (1000 * 60 * 60 * 24)),
        null);
    AirlinesController airlinesController = Mockito.mock(AirlinesController.class);
    Mockito.when(airlinesController.getFlightResults(searchRequest)).thenReturn(getSearchReponse("indico",searchRequest));
    SearchResponse response = searchService.getSearchResults(searchRequest);
    Assert.assertNotNull(response);
  }
  @Test
  public void getSearchResultsSuccesswithreturndate() {
    SearchRequest searchRequest = new SearchRequest("Chennai","oimbatore",
        new Date(new Date().getTime() + (1000 * 60 * 60 * 24)),
        new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 2)));
    AirlinesController airlinesController = Mockito.mock(AirlinesController.class);
    Mockito.when(airlinesController.getFlightResults(searchRequest)).thenReturn(getSearchReponse("indico",searchRequest));
    SearchResponse response = searchService.getSearchResults(searchRequest);
    Assert.assertNotNull(response);
  }

  @Test
  public void pastonwardjourneydatevalidationerror() {
    SearchRequest searchRequest = new SearchRequest("Chennai","oimbatore",
        new Date(new Date().getTime() - (1000 * 60 * 60 * 24)),
        new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 2)));
    AirlinesController airlinesController = Mockito.mock(AirlinesController.class);
    Mockito.when(airlinesController.getFlightResults(searchRequest)).thenReturn(getSearchReponse("indico",searchRequest));

    try{
      searchService.getSearchResults(searchRequest);
    }
    catch (PastDateValidationException ex){
      Assert.assertEquals("Travel date can't be a past date", ex.getMessage());
    }
  }

  @Test
  public void pastreturnjourneydatevalidationerror() {
    SearchRequest searchRequest = new SearchRequest("Chennai","oimbatore",
        new Date(new Date().getTime() + (1000 * 60 * 60 * 24)),
        new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 2)));
    AirlinesController airlinesController = Mockito.mock(AirlinesController.class);
    Mockito.when(airlinesController.getFlightResults(searchRequest)).thenReturn(getSearchReponse("indico",searchRequest));

    try{
      searchService.getSearchResults(searchRequest);
    }
    catch (PastDateValidationException ex){
      Assert.assertEquals("Return date can't be before onward journey date", ex.getMessage());
    }
  }

  private SearchResponse getSearchReponse(String url, SearchRequest request) {
    if(url.contains("indico")){
      return getResults("Indico", request);
    }
    else if(url.contains("deccan")){
      return getResults("Deccan", request);
    }
    else{
      return getResults("Emirates", request);
    }
  }

  private SearchResponse getResults(String Arilines, SearchRequest serverRequest) {
    SearchResponse response = new SearchResponse();
    List<FlightEntity> list = new ArrayList<>();
    int limit = rand.nextInt(10);
    long val = 100000L;
    for(int i = 0 ; i < limit; i++){
      list.add(new FlightEntity("FL"+rand.nextInt(1000),
          Arilines+" Airlines",
          formatter.format(new Timestamp(serverRequest.getTravelDate().getTime()+ (i+1) * 2000000)),
          formatter.format(new Timestamp(serverRequest.getTravelDate().getTime()+ (i+1) * 1000000)),
          (i+1)* (2000 - 1000),
          rand.nextInt(5),rand.nextInt(4000)));
    }
    response.setOnwardsFlights(list);
    if(serverRequest.getReturnDate() != null) {
      list = new ArrayList<>();
      limit = rand.nextInt(10);
      for (int i = 0; i < limit; i++) {
        list.add(new FlightEntity("FL" + rand.nextInt(1000),
            "Indico Airlines",
            formatter.format(
                new Timestamp(serverRequest.getReturnDate().getTime() + (i + 1) * 2000000)),
            formatter.format(
                new Timestamp(serverRequest.getReturnDate().getTime() + (i + 1) * 1000000)),
            (i + 1) * (2000 - 1000),
            rand.nextInt(5), rand.nextInt(4000)));
      }
      response.setReturnFlights(list);
    }
    return  response;
  }
}