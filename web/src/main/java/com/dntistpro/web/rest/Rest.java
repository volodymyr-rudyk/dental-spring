package com.dntistpro.web.rest;

import com.dntistpro.web.dto.BaseDTO;
import com.dntistpro.web.error.RestStatus;
import com.dntistpro.web.helper.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by vrudyk on 9/12/2016.
 */
public interface Rest {

  BaseDTO SUCCESS_DTO   = new BaseDTO(ResponseStatus.Success, RestStatus.SUCCESS);
  BaseDTO FAIL_DTO      = new BaseDTO(ResponseStatus.Failure, RestStatus.GENERAL_ERROR);
  BaseDTO INCORRECT_DTO = new BaseDTO(ResponseStatus.Failure, RestStatus.INCORRECT_ERROR);

  default BaseDTO baseDTO(ResponseStatus responseStatus, String message, int code) {
    return new BaseDTO(responseStatus, message, code);
  }

  default BaseDTO baseDTO(ResponseStatus responseStatus, RestStatus restStatus) {
    return new BaseDTO(responseStatus, restStatus);
  }

  default ResponseEntity<?> success() {
    return new ResponseEntity<>(SUCCESS_DTO, HttpStatus.OK);
  }

  default ResponseEntity<?> fail() {
    return new ResponseEntity<>(FAIL_DTO, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  default ResponseEntity<?> bad() {
    return new ResponseEntity<>(FAIL_DTO, HttpStatus.BAD_REQUEST);
  }

  default  <T extends BaseDTO> ResponseEntity<T> bad(T base) {
    base.setBaseDTO(FAIL_DTO);
    return new ResponseEntity<>(base, HttpStatus.BAD_REQUEST);
  }

  default ResponseEntity<?> bad(RestStatus restStatus) {
    BaseDTO base = new BaseDTO(ResponseStatus.Failure, restStatus);
    return new ResponseEntity<>(base, HttpStatus.BAD_REQUEST);
  }

  default ResponseEntity<?> incorrect() {
    return new ResponseEntity<>(INCORRECT_DTO, HttpStatus.BAD_REQUEST);
  }

  default <T extends BaseDTO> ResponseEntity<T> success(T base) {
    base.setBaseDTO(SUCCESS_DTO);
    return new ResponseEntity<>(base, HttpStatus.OK);
  }

  default <T extends BaseDTO> ResponseEntity<T> fail(T base) {
    base.setBaseDTO(FAIL_DTO);
    return new ResponseEntity<>(base, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  default <T extends BaseDTO> ResponseEntity<T> incorrect(T base) {
    base.setBaseDTO(INCORRECT_DTO);
    return new ResponseEntity<>(base, HttpStatus.BAD_REQUEST);
  }
}
