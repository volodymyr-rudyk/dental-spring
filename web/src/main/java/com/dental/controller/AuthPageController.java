package com.dental.controller;

import com.dental.test.Profi;
import com.dental.test.PropertyEditorRun;
import com.dental.view.ViewConfig;
import com.dental.view.ViewFolderConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by light on 3/28/2015.
 */
@Controller
@RequestMapping("/")
public class AuthPageController extends AbstractBasePageController {

  private static final Logger LOG = LoggerFactory.getLogger(AuthPageController.class);

  @Autowired
  private Profi profi;

  @Value("abc 100")
  private PropertyEditorRun propertyEditorRun;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(HttpServletRequest httpServletRequest, Locale locale) {
    LOG.info("/login request ...");
    profi.gogo();
    LOG.info(messageSource.getMessage("welcome", null, locale));
    return this.renderView(ViewConfig.PAGE_LOGIN);
  }

  @RequestMapping(value = "/signup")
  public String signup() {
    return this.renderView(ViewConfig.PAGE_SIGNUP);
  }

  @Override
  protected String getViewFolder() {
    return ViewFolderConfig.FOLDER_AUTH;
  }

}
