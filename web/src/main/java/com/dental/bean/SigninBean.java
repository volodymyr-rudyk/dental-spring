package com.dental.bean;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by light on 5/3/2015.
 */
public class SigninBean {

  @NotNull
  @Size(min = 5, max = 50)
  @Email
  private String email;

  @NotNull
  @Size(min = 8, max = 50)
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
