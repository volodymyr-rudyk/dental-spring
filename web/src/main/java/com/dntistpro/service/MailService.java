package com.dntistpro.service;

import javax.mail.MessagingException;

/**
 * Created by vrudyk on 9/5/2016.
 */
public interface MailService {
  void sendForgotPasswordEmail(String email, String forgotPasswordKey) throws MessagingException;
}
