package com.dental.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vrudyk on 9/15/2016.
 */
@RestController
@ControllerAdvice
@CrossOrigin
public abstract class AbstractBaseController implements Rest {

  private Logger logger = LoggerFactory.getLogger(AbstractBaseController.class);

  @ExceptionHandler(NullPointerException.class)
  protected void npeHandler(HttpServletRequest httpServletRequest, NullPointerException npe) {
    npe.printStackTrace();
    logger.debug(httpServletRequest.getContextPath());
  }

}