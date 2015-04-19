package com.dental.controllers.auth;

import com.dental.controllers.BaseController;
import com.dental.dao.entity.User;
import com.dental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by light on 3/28/2015.
 */
@Controller
@ControllerAdvice
public class AuthController extends BaseController {

//  @Autowired
//  private ProviderManager providerManager;

  @Autowired
  @Qualifier("myAuthenticationManager")
  private AuthenticationManager authenticationManager;

//  @Autowired
//  AuthenticationProvider authenticationProvider;

  @RequestMapping(value = "/login")
  public String login(HttpServletRequest request, HttpServletResponse response) throws NotFoundException {
    return "auth/login";
  }

  @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
  @ResponseBody
  public String login(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("username") String username,
                      @RequestParam("password") String password) throws NotFoundException {

    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
    token.setDetails(new WebAuthenticationDetails(request));
    Authentication authentication = authenticationManager.authenticate(token);
//    Authentication authentication = authenticationProvider.authenticate(token);

    SecurityContext securityContext = SecurityContextHolder.getContext();
    securityContext.setAuthentication(authentication);
    HttpSession session = request.getSession(true);
    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

//    if(authentication.isAuthenticated())
//      SecurityContextHolder.getContext().setAuthentication(authentication);

    return "OK";
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
