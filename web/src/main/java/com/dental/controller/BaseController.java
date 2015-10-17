package com.dental.controller;

import com.dental.exception.AuthenticationException;
import com.dental.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by light on 1/8/2015.
 */

@Component
@ControllerAdvice
public abstract class BaseController implements PageController {

  private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

  @Autowired
  protected MessageSource messageSource;

  protected String renderView(String view) {
    return getViewFolder() + "/" + view;
  }

  protected abstract String getViewFolder();

  @ExceptionHandler(NotFoundException.class)
  public String notFound(NotFoundException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
    String url = e.getUrl();
    LOG.debug("NotFoundHandler, url {}%s", url);
    if (!StringUtils.isEmpty(url)) {
      // TODO add logger
      response.sendRedirect(url);
    }
    return "404";
  }

  @ExceptionHandler(AuthenticationException.class)
  public void authenticationRequired(AuthenticationException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.sendRedirect("/auth/login");
  }
}
