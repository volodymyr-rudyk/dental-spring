package com.dental.exception;

/**
 * Created by admin on 27.05.2015.
 */
public class RequiredAuthenticationException extends RuntimeException {
  public RequiredAuthenticationException() {
    super();
  }

  public RequiredAuthenticationException(String msg, Throwable ex) {
    super(msg, ex);
  }

}
