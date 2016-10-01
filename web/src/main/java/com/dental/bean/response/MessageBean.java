package com.dental.bean.response;

/**
 * Created by vrudyk on 10/1/2016.
 */
public class MessageBean {
  private String message;

  public MessageBean(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
