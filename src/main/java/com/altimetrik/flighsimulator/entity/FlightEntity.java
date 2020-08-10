package com.altimetrik.flighsimulator.entity;

public class FlightEntity {
    private String FlightNumber;
    private String AirlineName;
    private String ArrivalTime;
    private String DepartureTime;
    private long durationinSeconds;
    private int noOfStops;
    private double price;

  public FlightEntity(String flightNumber, String airlineName, String arrivalTime, String departureTime,
      long duration, int noOFStops, double price) {
    FlightNumber = flightNumber;
    AirlineName = airlineName;
    ArrivalTime = arrivalTime;
    DepartureTime = departureTime;
    this.durationinSeconds = duration;
    this.noOfStops = noOFStops;
    this.price = price;
  }

  public String getFlightNumber() {
    return FlightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    FlightNumber = flightNumber;
  }

  public String getAirlineName() {
    return AirlineName;
  }

  public void setAirlineName(String airlineName) {
    AirlineName = airlineName;
  }

  public String getArrivalTime() {
    return ArrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    ArrivalTime = arrivalTime;
  }

  public String getDepartureTime() {
    return DepartureTime;
  }

  public void setDepartureTime(String departureTime) {
    DepartureTime = departureTime;
  }

  public long getDurationinSeconds() {
    return durationinSeconds;
  }

  public void setDurationinSeconds(long durationinSeconds) {
    this.durationinSeconds = durationinSeconds;
  }

  public int getNoOfStops() {
    return noOfStops;
  }

  public void setNoOfStops(int noOfStops) {
    this.noOfStops = noOfStops;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
