package com.dental.controller.auth;

import com.dental.bean.SignupBean;
import com.dental.bean.UserBean;
import com.dental.controller.BaseController;
import com.dental.exception.AuthenticationException;
import com.dental.exception.NotFoundException;
import com.dental.service.AuthService;
import com.dental.view.ViewConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by light on 3/28/2015.
 */
@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        LOG.debug("Login page entered ...");
        return this.renderView(PAGE_LOGIN);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView authenticate(HttpServletRequest request, HttpServletResponse response,
                               @Valid UserBean userBean, BindingResult result, Model model) throws IOException {

        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            LOG.debug("Entered data has errors");
            model.addAttribute("validationErrors", result.getFieldErrors());
            modelAndView.setViewName(this.renderView(PAGE_LOGIN));
            return modelAndView;
        }

        try {
            authService.authenticate(userBean, request);
            modelAndView.setViewName("redirect:/profile");
            LOG.debug("Success, Redirect to profile page");
            return modelAndView;
        } catch (BadCredentialsException bex) {
            LOG.debug("Bad credentials ...");
            model.addAttribute("error", "Bad credential");
            modelAndView.setViewName(this.renderView(PAGE_LOGIN));
            return modelAndView;
        } catch (AuthenticationException e) {
            LOG.debug("AuthenticationException = " + e.getMessage());
            model.addAttribute("error", "Auth Exception");
            modelAndView.setViewName(this.renderView(PAGE_LOGIN));
            return modelAndView;
        }
    }

    @RequestMapping(value = "/signup")
    public String signup() {
        return this.renderView("signup");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signuppost(HttpServletResponse response, SignupBean signupBean) throws NotFoundException, IOException {

        if (StringUtils.isEmpty(signupBean.getFirstName()) ||
                StringUtils.isEmpty(signupBean.getLastName()) ||
                StringUtils.isEmpty(signupBean.getLogin()) ||
                StringUtils.isEmpty(signupBean.getPassword())
                ) {
            response.sendRedirect("/signup?fail");
            return;
        }
        authService.signup(signupBean);
        response.sendRedirect("/login");
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response, Model model) throws NotFoundException, IOException {
        authService.logout(request, response);
        response.sendRedirect("/auth/login");
    }

    @RequestMapping(value = "/denied")
    public String denied() throws NotFoundException {
        return this.renderView("denied");
    }

    @Override
    protected String getViewFolder() {
        return ViewConfig.FOLDER_AUTH;
    }

}
