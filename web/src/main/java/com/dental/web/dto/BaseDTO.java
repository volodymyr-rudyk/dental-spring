package com.dental.web.dto;

import com.dental.web.ResponseStatus;

/**
 * Created by vrudyk on 11/5/2015.
 */
public abstract class BaseDTO {

  protected ResponseStatus responseStatus;
  protected String message;
  protected int code;

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
