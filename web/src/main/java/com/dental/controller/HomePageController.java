package com.dental.controller;

import com.dental.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//*
/*Created by light on 3/14/2015.
*/

@Controller
public class HomePageController extends AbstractBasePageController {

  private static String viewName = "index";

  @RequestMapping(value = "/")
  public String about(HttpServletRequest request, HttpServletResponse response, Model model) throws NotFoundException {
    return this.renderView(viewName);
  }

  @Override
  protected String getViewFolder() {
    return "";
  }

}
