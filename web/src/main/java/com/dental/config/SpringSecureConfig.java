package com.dental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by admin on 06.04.2015.
 */
@EnableWebSecurity
@Configuration
public class SpringSecureConfig extends WebSecurityConfigurerAdapter {

  @Override protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/secure").access("hasRole('ROLE_USER')")
      .and().formLogin().loginPage("/login");
  }
}
