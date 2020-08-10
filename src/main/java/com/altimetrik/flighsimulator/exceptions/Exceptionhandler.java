package com.altimetrik.flighsimulator.exceptions;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Exceptionhandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    if(ex.getErrorCount() > 0) {
      String[] errors = new String[ex.getErrorCount()];
      List<ObjectError> errorList = ex.getAllErrors();
      int i = 0 ;
      for(ObjectError o : errorList){
        errors[i++] = o.getDefaultMessage();
      }
      ParameterValidationException parameterValidationException = new ParameterValidationException();
      parameterValidationException.setError("Bad request format");
      parameterValidationException.setErrors(errors);
      return new ResponseEntity<>(parameterValidationException,headers,status);
    }
    return handleExceptionInternal(ex,(Object)null, headers, status, request);
  }
  @ExceptionHandler(value = PastDateValidationException.class)
  public ResponseEntity<Object> handlePastDateValidationExceptions(PastDateValidationException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Object> handleAllExceptions(Exception ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
