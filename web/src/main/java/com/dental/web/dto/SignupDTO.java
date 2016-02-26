package com.dental.web.dto;

import com.dental.web.status.ResponseStatus;

/**
 * Created by vrudyk on 12/3/2015.
 */
public class SignupDTO {

  private BaseDTO baseDTO;
  private String email;

  public SignupDTO(BaseDTO baseDTO) {
    this.baseDTO = baseDTO;
  }

  public ResponseStatus getResponseStatus() {
    return baseDTO.getResponseStatus();
  }

  public String getMessage() {
    return baseDTO.getMessage();
  }

  public int getCode() {
    return baseDTO.getCode();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
