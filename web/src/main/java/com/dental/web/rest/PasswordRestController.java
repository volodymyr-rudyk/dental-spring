package com.dental.web.rest;

import com.dental.bean.ForgotPasswordBean;
import com.dental.bean.ResetPasswordBean;
import com.dental.persistence.entity.ForgotPassword;
import com.dental.service.MailService;
import com.dental.service.PasswordService;
import com.dental.service.UserService;
import com.dental.web.dto.BaseDTO;
import com.dental.web.error.RestStatus;
import com.dental.web.status.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by vrudyk on 9/7/2016.
 */
@RestController
public class PasswordRestController extends BaseRestController {

  public static final String INFO_DNTISTPRO_COM = "info@dntistpro.com";
  public static final String SUBJECT = "Forgot Password";

  private Logger LOG = LoggerFactory.getLogger(PasswordRestController.class);

  @Autowired
  private MailService mailService;

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordService passwordService;

  @RequestMapping(value = "/forgot-password", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> forgotPassword(@RequestBody @Valid ForgotPasswordBean forgotPasswordBean, BindingResult result) {

    if (result.hasErrors()) return incorrect();

    Optional<ForgotPassword> forgotPasswordOptional = passwordService.createForgotPassword(forgotPasswordBean.getEmail());

    if (forgotPasswordOptional.isPresent()) {
      try {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(INFO_DNTISTPRO_COM);
        mailMessage.setTo(forgotPasswordBean.getEmail());

        mailMessage.setSubject(SUBJECT);

        String link = "<a href=" + "\"http://188.191.71.7:9999/reset-password/" + forgotPasswordOptional.get().getForgotPasswordKey() + "\""+ ">Reset Password</a>";

        mailMessage.setText("Hello world, Your new password = start123 =) " + link);
        mailService.send(mailMessage);
        LOG.info("Mail is sent to = " + forgotPasswordBean.getEmail());
        return success();
      } catch (Exception e) {
        LOG.info(e.getMessage());
      }
    }
    return bad();
  }

  @RequestMapping(value = "/reset-password/{forgotPasswordKey}", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> resetPassword(@PathVariable(value = "forgotPasswordKey") String forgotPasswordKey,
                                         @RequestBody @Valid ResetPasswordBean resetPasswordBean, BindingResult result) {
    if (result.hasErrors()) return incorrect();

    passwordService.useForgotPassword(forgotPasswordKey, resetPasswordBean.getPassword());
    return success();
  }
}
