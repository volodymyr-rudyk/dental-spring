package com.dental.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vrudyk on 11/4/2015.
 */
@RestController
@ControllerAdvice
@RequestMapping(value = "/rest")
@CrossOrigin
public class BaseRestController implements Rest{

  private Logger logger = LoggerFactory.getLogger(BaseRestController.class);

  @ExceptionHandler(NullPointerException.class)
  public void npeHandler(HttpServletRequest httpServletRequest, NullPointerException npe) {
    npe.printStackTrace();
    logger.debug(httpServletRequest.getContextPath());
  }

}
