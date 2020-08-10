package com.altimetrik.flighsimulator.service.Impl;

import com.altimetrik.flighsimulator.Util.DateUtil;
import com.altimetrik.flighsimulator.exceptions.PastDateValidationException;
import com.altimetrik.flighsimulator.entity.SearchRequest;
import com.altimetrik.flighsimulator.entity.SearchResponse;
import com.altimetrik.flighsimulator.microservicecontroller.AirlinesController;
import com.altimetrik.flighsimulator.microservicecontroller.DeccanAPIController;
import com.altimetrik.flighsimulator.microservicecontroller.EmiratesAPIController;
import com.altimetrik.flighsimulator.microservicecontroller.IndicoAPICoontroller;
import com.altimetrik.flighsimulator.service.SearchService;
import org.springframework.stereotype.Service;



@Service
public class SearchServiceImpl implements SearchService {

  private AirlinesController airlinesController;

  public void setAirlinesController(
      AirlinesController airlinesController) {
    this.airlinesController = airlinesController;
  }

  @Override
  public SearchResponse getSearchResults(SearchRequest request){
    if(request.getTravelDate().before(DateUtil.getDateTime())){
      throw new PastDateValidationException("Travel date can't be a past date");
    }
    if(request.getReturnDate() != null && request.getReturnDate().before(request.getTravelDate())){
      throw new PastDateValidationException("Return date can't be before onward journey date");
    }
    setAirlinesController(getAirlinesController(request));
    return airlinesController.getFlightResults(request);
  }

  private AirlinesController getAirlinesController(SearchRequest request) {
    if(request.getSource().contains("Chennai")){
      return new IndicoAPICoontroller();
    }else if(request.getSource().contains("washington")){
      return new DeccanAPIController();
    }else{
      return new EmiratesAPIController();
    }
  }
}
