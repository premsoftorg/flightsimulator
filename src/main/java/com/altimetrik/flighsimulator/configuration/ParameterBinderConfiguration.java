package com.altimetrik.flighsimulator.configuration;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
  class ParameterBinderConfiguration {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
      binder.initDirectFieldAccess();
    }

  }