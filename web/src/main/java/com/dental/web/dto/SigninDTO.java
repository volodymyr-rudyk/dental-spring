package com.dental.web.dto;

/**
 * Created by vrudyk on 11/5/2015.
 */
public class SigninDTO extends BaseDTO {

  private String userEmail;

  public SigninDTO() {

  }

  public SigninDTO(BaseDTO base) {
    this.responseStatus = base.responseStatus;
    this.message = base.message;
    this.code = base.code;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
}
