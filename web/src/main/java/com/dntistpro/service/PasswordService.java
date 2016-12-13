package com.dntistpro.service;

import com.dntistpro.persistence.entity.ForgotPasswordEntity;

import java.util.Optional;

/**
 * Created by vrudyk on 9/7/2016.
 */
public interface PasswordService {

  Optional<ForgotPasswordEntity> createForgotPassword(String email);

  void useForgotPassword(String forgotPasswordKey, String password);

}
