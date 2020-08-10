package com.altimetrik.flighsimulator.exceptions;

public class ParameterValidationException{

  private String error;

  private String[] errors;

  public ParameterValidationException(){}

  public String[] getErrors() {
    return errors;
  }

  public void setErrors(String[] errors) {
    this.errors = errors;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
