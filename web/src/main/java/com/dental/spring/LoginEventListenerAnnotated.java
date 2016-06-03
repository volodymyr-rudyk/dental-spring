package com.dental.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
