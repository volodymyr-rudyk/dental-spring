package com.dental.web.dto;

/**
 * Created by vrudyk on 11/5/2015.
 */
public class SigninDTO extends BaseDTO{

  public SigninDTO() {

  }

  public SigninDTO(BaseDTO base){
    this.responseStatus = base.responseStatus;
    this.message = base.message;
    this.code = base.code;
  }

//  private int userId;
//  private String userEmail;
//
//  public int getUserId() {
//    return userId;
//  }
//
//  public void setUserId(int userId) {
//    this.userId = userId;
//  }
//
//  public String getUserEmail() {
//    return userEmail;
//  }
//
//  public void setUserEmail(String userEmail) {
//    this.userEmail = userEmail;
//  }
}
