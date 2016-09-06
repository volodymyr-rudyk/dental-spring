package com.dental.web.error;

/**
 * Created by vrudyk on 2/16/2016.
 */
public enum RestStatus {

  SUCCESS(0, "OK"),
  GENERAL_ERROR(-1, "Server error"),
  INCORRECT_ERROR(-2, "Incorrect data"),
  SINGUP_ERROR(-3, "Registration failed");

  private int code;
  private String msg;
  RestStatus(int code, String msg){
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
