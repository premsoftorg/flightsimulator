package com.altimetrik.flighsimulator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PastDateValidationException extends RuntimeException{

  public PastDateValidationException(String message){
    super(message);
  }
}
