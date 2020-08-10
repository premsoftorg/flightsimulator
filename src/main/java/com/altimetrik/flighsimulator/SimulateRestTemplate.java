package com.altimetrik.flighsimulator;

import com.altimetrik.flighsimulator.entity.FlightEntity;
import com.altimetrik.flighsimulator.entity.SearchRequest;
import com.altimetrik.flighsimulator.entity.SearchResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulateRestTemplate {
  private static Random rand = new Random();
  private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public SearchResponse exchange(String url,  SearchRequest request){
    return getSearchReponse(url, request);
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
