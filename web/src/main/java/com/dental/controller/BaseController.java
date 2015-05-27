package com.dental.controller;

import com.dental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by light on 1/8/2015.
 */

@Component
@ControllerAdvice
public abstract class BaseController {

    @Autowired
    protected MessageSource messageSource;

    protected String renderView(String view) {
      return new StringBuilder(getViewFolder()).append("/").append(view).toString();
    }

  protected abstract String getViewFolder();

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "404";
    }

}
