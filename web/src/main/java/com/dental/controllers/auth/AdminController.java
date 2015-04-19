package com.dental.controllers.auth;

import com.dental.controllers.BaseController;
import com.dental.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by light on 3/28/2015.
 */
@Controller
@ControllerAdvice
@RequestMapping("/admin")
public class AdminController extends BaseController {

  @RequestMapping(value = "/login")
  @ResponseBody
  public String login(HttpServletRequest request, HttpServletResponse response) throws NotFoundException {
     return "admin/login";
  }

  @RequestMapping(value = "/logout")
  public String logout() throws NotFoundException {
    return "auth/logout";
  }

  @RequestMapping(value = "/denied")
  public String denied() throws NotFoundException {
    return "auth/denied";
  }

  @RequestMapping(value = "/secure")
  public String secure() throws NotFoundException {
    return "auth/secure";
  }

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "404";
    }
}
