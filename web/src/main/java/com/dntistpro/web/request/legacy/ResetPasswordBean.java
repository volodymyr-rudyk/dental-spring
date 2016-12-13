package com.dntistpro.web.request.legacy;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by vrudyk on 9/7/2016.
 */
public class ResetPasswordBean {

  @NotNull
  @Size(min = 8, max = 50)
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
