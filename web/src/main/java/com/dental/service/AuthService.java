package com.dental.service;

import com.dental.bean.SigninBean;
import com.dental.bean.SignupBean;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.User;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by light on 5/3/2015.
 */
public interface AuthService {

  UserDetails authenticate(SigninBean signinBean, HttpServletRequest request) throws AuthenticationException;

  void signup(SignupBean signupBean);

  void logout(HttpServletRequest request, HttpServletResponse response);

  Dentist getLoggedInDentist();

  User getLoggedUser();

}
