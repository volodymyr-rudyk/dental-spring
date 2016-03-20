package com.dental.controller;

import com.dental.exception.NotFoundException;
import com.dental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vrudyk on 12/19/2015.
 */
@Controller
public class LogoutController extends AbstractBasePageController {

  @Autowired
  AuthService authService;

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public void profile(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws NotFoundException, IOException {
    authService.logout(request, response);
    response.sendRedirect("/login");
  }

  @Override
  protected String getViewFolder() {
    return "";
  }
}
