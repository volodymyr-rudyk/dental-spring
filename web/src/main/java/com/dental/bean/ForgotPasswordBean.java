package com.dental.bean;

import org.hibernate.validator.constraints.Email;

/**
 * Created by vrudyk on 9/5/2016.
 */
public class ForgotPasswordBean {
  @Email
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
