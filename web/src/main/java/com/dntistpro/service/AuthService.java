package com.dntistpro.service;

import com.dntistpro.web.request.LoginRequest;
import com.dntistpro.web.request.legacy.SignupBean;
import com.dntistpro.persistence.entity.DentistEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by light on 5/3/2015.
 */
public interface AuthService {

  String authenticateToken(LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException;

  UserDetails authenticate(LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException;

  void signup(SignupBean signupBean);

  void logout(HttpServletRequest request, HttpServletResponse response);

  DentistEntity getLoggedInDentist();

}
