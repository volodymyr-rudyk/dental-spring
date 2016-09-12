package com.dental.service.impl;

import com.dental.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by vrudyk on 9/5/2016.
 */
@Service
public class MailServiceImpl implements MailService {

  private Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);

  public static final String FROM = "info@dntistpro.com";
  public static final String SUBJECT = "Forgot Password";
  public static final String HOST = "http://188.191.71.7:9999";
  public static final String LOCALHOST = "localhost";

  private void send(MimeMessage mailMessage) throws MessagingException {
    Transport.send(mailMessage);
  }

  @Override
  public void sendForgotPasswordEmail(String email, String forgotPasswordKey) throws MessagingException {
    MimeMessage message = new MimeMessage(getSession());
    message.setFrom(new InternetAddress(FROM));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
    message.setSubject(SUBJECT);

    String content = "<a href=" + "\"" + HOST + "/reset-password/" + forgotPasswordKey + "\"" + ">Reset Password</a>";
    message.setContent(content, "text/html");
    send(message);
    LOG.info("Mail is sent to : " + email);
  }

  private Session getSession() {
    Properties props = new Properties();
    props.put("mail.smtp.host", LOCALHOST);
    return Session.getInstance(props);
  }
}
