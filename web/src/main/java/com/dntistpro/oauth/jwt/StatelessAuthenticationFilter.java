package com.dntistpro.oauth.jwt;

import com.dntistpro.web.rest.AuthRestController;
import com.google.common.base.Preconditions;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.impl.DefaultJwtParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.expression.ParseException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vrudyk on 12/3/2016.
 */
public class StatelessAuthenticationFilter extends GenericFilterBean {

  private Logger LOG = LoggerFactory.getLogger(AuthRestController.class);

  @Autowired
  TokenAuthenticationService tokenAuthenticationService;

  public StatelessAuthenticationFilter() {
    LOG.info("StatelessAuthenticationFilter constructor");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    throws IOException, ServletException {
    ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
    Authentication authentication = tokenAuthenticationService.getAuthentication((HttpServletRequest) request);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(request, response);
    SecurityContextHolder.getContext().setAuthentication(null);
  }
}