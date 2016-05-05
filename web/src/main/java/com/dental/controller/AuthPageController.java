package com.dental.controller;

import com.dental.view.ViewConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by light on 3/28/2015.
 */
@Controller
@RequestMapping("/")
public class AuthPageController extends AbstractBasePageController {

  private static final Logger LOG = LoggerFactory.getLogger(AuthPageController.class);

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() {
    return this.renderView(PAGE_LOGIN);
  }

  @RequestMapping(value = "/signup")
  public String signup() {
    return this.renderView(PAGE_SIGNUP);
  }

  @Override
  protected String getViewFolder() {
    return ViewConfig.FOLDER_AUTH;
  }

}