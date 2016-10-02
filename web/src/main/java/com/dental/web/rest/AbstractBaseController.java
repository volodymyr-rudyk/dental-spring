package com.dental.web.rest;

import com.dental.exception.EntityNotFountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vrudyk on 9/15/2016.
 */
@RestController
@ControllerAdvice(annotations = RestController.class)
@CrossOrigin
public abstract class AbstractBaseController implements Rest {

  private Logger logger = LoggerFactory.getLogger(AbstractBaseController.class);

  @ExceptionHandler(NullPointerException.class)
  protected void npeHandler(HttpServletRequest httpServletRequest, NullPointerException npe) {
    npe.printStackTrace();
    logger.debug(httpServletRequest.getContextPath());
  }

  @ExceptionHandler(EntityNotFountException.class)
  protected ResponseEntity<?> entityNotFount(HttpServletRequest httpServletRequest, EntityNotFountException e) {
    logger.error(e.getMessage());
    return new ResponseEntity<>(e.getMessageBean(), HttpStatus.BAD_REQUEST);
  }

}