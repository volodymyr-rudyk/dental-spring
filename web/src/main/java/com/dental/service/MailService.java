package com.dental.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by vrudyk on 9/5/2016.
 */
public interface MailService {
  void send(SimpleMailMessage mailMessage);
}
