package com.dental.service;

import com.dental.beans.SignupBean;
import com.dental.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by light on 5/3/2015.
 */
public interface AuthService {

    void authenticate(UserBean userBean, HttpServletRequest request);

    void logout(HttpServletRequest request, HttpServletResponse response);

    void signup(SignupBean signupBean);
}
