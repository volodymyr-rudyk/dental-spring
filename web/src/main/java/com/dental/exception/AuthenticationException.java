package com.dental.exception;

/**
 * Created by admin on 27.05.2015.
 */
public class AuthenticationException extends RuntimeException{
  public AuthenticationException() {
    super();
  }

  public AuthenticationException(String msg, Throwable ex) {
    super(msg, ex);
  }

}
