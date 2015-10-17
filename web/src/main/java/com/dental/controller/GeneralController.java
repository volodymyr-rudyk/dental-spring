package com.dental.controller;

import com.dental.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by light on 26.05.2015.
 */
@Controller
public class GeneralController extends BaseController {

  @RequestMapping(value = "/about")
  public String about(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = false) String name) throws
      NotFoundException {

    if (name != null) {
      throw new NotFoundException("URL : /about");
    }
    return "/about/about";
  }

  @RequestMapping(value = "/howto")
  public String howto() {
    return "/about/about";
  }

  @Override
  protected String getViewFolder() {
    return null;
  }
}
