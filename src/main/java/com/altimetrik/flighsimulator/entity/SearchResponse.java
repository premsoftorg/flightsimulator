package com.altimetrik.flighsimulator.entity;

import java.util.List;

public class SearchResponse {
    private List<FlightEntity>  onwardsFlights;
    private List<FlightEntity>  returnFlights;
    private int onwardFlightCount;
    private int returnFlightCount;

  public SearchResponse(){}

  public List<FlightEntity> getOnwardsFlights() {
    return onwardsFlights;
  }

  public void setOnwardsFlights(
      List<FlightEntity> onwardsFlights) {
    this.onwardsFlights = onwardsFlights;
    onwardFlightCount = onwardsFlights == null ? 0 : onwardsFlights.size();
  }

  public List<FlightEntity> getReturnFlights() {
    return returnFlights;
  }

  public void setReturnFlights(
      List<FlightEntity> returnFlights) {
    this.returnFlights = returnFlights;
    returnFlightCount = returnFlights == null ? 0 : returnFlights.size();
  }

  public int getOnwardFlightCount() {
    return onwardFlightCount;
  }

  public int getReturnFlightCount() {
    return returnFlightCount;
  }
}
