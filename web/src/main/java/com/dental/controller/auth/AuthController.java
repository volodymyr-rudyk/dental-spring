package com.dental.controller.auth;

import com.dental.bean.SignupBean;
import com.dental.bean.UserBean;
import com.dental.controller.BaseController;
import com.dental.exception.AuthenticationException;
import com.dental.exception.NotFoundException;
import com.dental.service.AuthService;
import com.dental.view.ViewConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by light on 3/28/2015.
 */
@Controller
//@RequestMapping("/auth")
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return renderView("login");
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public void authenticate(HttpServletRequest request, HttpServletResponse response,
                      UserBean userBean) throws IOException {
    try {
      authService.authenticate(userBean, request);
    } catch (BadCredentialsException bex) {
      // TODO log exeption
      response.sendRedirect("/login?fail=badcredentials");
      return;
    } catch (AuthenticationException e){
            // TODO log exeption
            response.sendRedirect("/login?fail");
            return;
        }
        response.sendRedirect("/profile");
    }

    @RequestMapping(value = "/signup")
    public String signup() throws NotFoundException, IOException {
        return "/auth/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signuppost(HttpServletResponse response, SignupBean signupBean) throws NotFoundException, IOException {

        if(StringUtils.isEmpty(signupBean.getFirstName()) ||
                StringUtils.isEmpty(signupBean.getLastName()) ||
                StringUtils.isEmpty(signupBean.getLogin()) ||
                StringUtils.isEmpty(signupBean.getPassword())
                ) {
            response.sendRedirect("/signup?fail");
          return;
        }
        authService.signup(signupBean);
        response.sendRedirect("/login");
//        return "/auth/signup";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws NotFoundException {
        authService.logout(request, response);
        return "auth/login";
    }

    @RequestMapping(value = "/denied")
    public String denied() throws NotFoundException {
        return "auth/denied";
    }

    @RequestMapping(value = "/secure")
    public String secure() throws NotFoundException {
        return "auth/secure";
    }

    @Override protected String getViewFolder() {
        return ViewConfig.FOLDER_AUTH;
    }

}
