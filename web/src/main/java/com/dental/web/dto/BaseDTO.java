package com.dental.web.dto;

import com.dental.web.error.RestStatus;
import com.dental.web.helper.ResponseStatus;

/**
 * Created by vrudyk on 11/5/2015.
 */
public class BaseDTO {

  protected ResponseStatus responseStatus;
  protected String message;
  protected int code;

  public BaseDTO() {

  }

  public BaseDTO(ResponseStatus responseStatus, RestStatus restStatus) {
    this.responseStatus = responseStatus;
    this.message = restStatus.getMsg();
    this.code = restStatus.getCode();
  }

  public BaseDTO(ResponseStatus responseStatus, String message, int code) {
    this.responseStatus = responseStatus;
    this.message = message;
    this.code = code;
  }

  public BaseDTO(BaseDTO base) {
    setBaseDTO(base);
  }

  public void setBaseDTO(BaseDTO base) {
    this.responseStatus = base.responseStatus;
    this.message = base.message;
    this.code = base.code;
  }

  public ResponseStatus getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(ResponseStatus responseStatus) {
    this.responseStatus = responseStatus;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

}
