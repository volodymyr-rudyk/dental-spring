package com.dental.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by vrudyk on 5/28/2016.
 */
@Component
public class LoginEventListener implements ApplicationListener<LoginEvent> {

  private static final Logger LOG = LoggerFactory.getLogger(LoginEventListener.class);

  @PostConstruct
  public void post() {
    LOG.info("LoginEventListener init");
  }

  @Override
  public void onApplicationEvent(LoginEvent loginEvent) {
    LOG.info("User with email has logged in {0}", loginEvent.getEmail() );
    System.out.println("User has logged in " + loginEvent.getEmail() );
  }
}
