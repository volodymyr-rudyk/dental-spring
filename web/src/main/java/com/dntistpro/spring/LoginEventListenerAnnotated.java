package com.dntistpro.spring;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by vrudyk on 5/28/2016.
 */
@Component
public class LoginEventListenerAnnotated {

  @EventListener({LoginEvent.class})
  public void onLogin(LoginEvent loginEvent) {
    System.out.println("LoginEventListenerAnnotated  ser has logged in " + loginEvent.getEmail() );
  }
}
