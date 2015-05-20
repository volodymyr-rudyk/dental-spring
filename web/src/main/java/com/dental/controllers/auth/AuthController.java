package com.dental.controllers.auth;

import com.dental.beans.SignupBean;
import com.dental.beans.UserBean;
import com.dental.controllers.BaseController;
import com.dental.exception.NotFoundException;
import com.dental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by light on 3/28/2015.
 */
@Controller
@ControllerAdvice
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws NotFoundException {
        return "auth/login";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response,
                      UserBean userBean) throws IOException {
        try {
            authService.authenticate(userBean, request);
        }catch (RuntimeException e){
            response.sendRedirect("/login?fail");
            return;
        }
        response.sendRedirect("/secure");
    }

    @RequestMapping(value = "/signup")
    public String signup() throws NotFoundException, IOException {
        return "/auth/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signuppost(HttpServletResponse response, SignupBean signupBean) throws NotFoundException, IOException {

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

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "404";
    }

}
