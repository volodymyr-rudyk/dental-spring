package com.dental.web.rest;

import com.dental.web.dto.BaseDTO;
import com.dental.web.error.RestStatus;
import com.dental.web.status.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  protected static final BaseDTO SUCCESS_DTO = new BaseDTO(ResponseStatus.Success, RestStatus.SUCCESS);
  protected static final BaseDTO FAIL_DTO = new BaseDTO(ResponseStatus.Failure, RestStatus.GENERAL_ERROR);
  protected static final BaseDTO INCORRECT_DTO = new BaseDTO(ResponseStatus.Failure, RestStatus.INCORRECT_ERROR);

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

  protected ResponseEntity<?> success() {
    return new ResponseEntity<>(SUCCESS_DTO, HttpStatus.OK);
  }

  protected ResponseEntity<?> fail() {
    return new ResponseEntity<>(FAIL_DTO, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  protected ResponseEntity<?> bad() {
    return new ResponseEntity<>(FAIL_DTO, HttpStatus.BAD_REQUEST);
  }

  protected ResponseEntity<?> incorrect() {
    return new ResponseEntity<>(INCORRECT_DTO, HttpStatus.BAD_REQUEST);
  }
}
