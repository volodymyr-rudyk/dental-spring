package com.dental.web.rest;

import com.dental.web.dto.BaseDTO;
import com.dental.web.error.RestStatus;
import com.dental.web.status.ResponseStatus;
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
public class BaseRestController {

  private Logger logger = LoggerFactory.getLogger(BaseRestController.class);

  @ExceptionHandler(NullPointerException.class)
  public void npeHandler(HttpServletRequest httpServletRequest, NullPointerException npe) {
    npe.printStackTrace();
    logger.debug(httpServletRequest.getContextPath());
  }

  protected BaseDTO baseDTO(ResponseStatus responseStatus, String message, int code) {
    return new BaseDTO(responseStatus, message, code);
  }

  protected BaseDTO baseDTO(ResponseStatus responseStatus, RestStatus restStatus) {
    return new BaseDTO(responseStatus, restStatus);
  }

}
