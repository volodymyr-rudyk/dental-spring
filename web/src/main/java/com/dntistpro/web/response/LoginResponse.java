package com.dntistpro.web.response;

/**
 * Created by vrudyk on 12/9/2016.
 */
public class LoginResponse implements Response {

  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
