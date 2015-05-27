package com.dental.service;

import com.dental.bean.SignupBean;
import com.dental.bean.UserBean;
import com.dental.exception.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by light on 5/3/2015.
 */
public interface AuthService {

    void authenticate(UserBean userBean, HttpServletRequest request) throws AuthenticationException;

    void logout(HttpServletRequest request, HttpServletResponse response);

    void signup(SignupBean signupBean);
}
