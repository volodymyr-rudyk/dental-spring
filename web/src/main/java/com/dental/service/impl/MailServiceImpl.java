package com.dental.service.impl;

import com.dental.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by vrudyk on 9/5/2016.
 */
@Service
public class MailServiceImpl implements MailService {

  @Autowired
  private MailSender mailSender;

  public void send(SimpleMailMessage mailMessage) {
    mailSender.send(mailMessage);
  }

}
