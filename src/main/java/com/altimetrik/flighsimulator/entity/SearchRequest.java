package com.altimetrik.flighsimulator.entity;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class SearchRequest {
  @NotBlank(message = "Source city can't be blank")
  private String source;
  @NotBlank(message = "Destination city can't be blank")
  private String destination;
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  @NotNull(message = "Date field required in dd-MM-yyyy format")
  private Date travelDate;
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  private Date returnDate;

  private SearchRequest(){

  }

  public SearchRequest(
      @NotBlank(message = "Source city can't be blank") String source,
      @NotBlank(message = "Destination city can't be blank") String destination,
      @DateTimeFormat(pattern = "dd-MM-yyyy") @NotNull(message = "Date field required in dd-MM-yyyy format") Date travelDate,
      @DateTimeFormat(pattern = "dd-MM-yyyy") Date returnDate) {
    this.source = source;
    this.destination = destination;
    this.travelDate = travelDate;
    this.returnDate = returnDate;
  }

  public String getSource() {
    return source;
  }

  public String getDestination() {
    return destination;
  }


  public Date getTravelDate() {
    return travelDate;
  }


  public Date getReturnDate() {
    return returnDate;
  }

}
