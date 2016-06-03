package com.dental.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Created by vrudyk on 5/28/2016.
 */
public class LoginEvent extends ApplicationEvent {

//  private String firstName;
//  private String lastName;
  private String email;

  public LoginEvent(Object source) {
    super(source);
  }

  public LoginEvent(Object o, String email) {
    super(o);
    this.email = email;
  }

  public String getEmail() {
    return email;
  }
}
