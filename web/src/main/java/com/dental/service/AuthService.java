package com.dental.service;

import com.dental.bean.SignupBean;
import com.dental.bean.UserBean;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by light on 5/3/2015.
 */
public interface AuthService {

  void authenticate(UserBean userBean, HttpServletRequest request) throws AuthenticationException;

  void signup(SignupBean signupBean);

  void logout(HttpServletRequest request, HttpServletResponse response);
}
