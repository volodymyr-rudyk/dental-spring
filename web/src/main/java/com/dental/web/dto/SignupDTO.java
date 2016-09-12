package com.dental.web.dto;

/**
 * Created by vrudyk on 12/3/2015.
 */
public class SignupDTO extends BaseDTO {

  private String email;

  public SignupDTO() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
