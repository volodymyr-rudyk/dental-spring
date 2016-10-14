package com.dental.web.rest;

import com.dental.bean.request.ForgotPasswordBean;
import com.dental.bean.request.ResetPasswordBean;
import com.dental.persistence.entity.ForgotPasswordEntity;
import com.dental.service.MailService;
import com.dental.service.PasswordService;
import com.dental.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by vrudyk on 9/7/2016.
 */
@RestController
public class PasswordRestController extends BaseRestController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PasswordRestController.class);

  @Autowired
  private MailService mailService;

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordService passwordService;

  @RequestMapping(value = "/forgot-password", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity forgotPassword(@RequestBody @Valid ForgotPasswordBean forgotPasswordBean, BindingResult result) {

    if (result.hasErrors()) {
      return incorrect();
    }

    Optional<ForgotPasswordEntity> forgotPasswordOptional = passwordService.createForgotPassword(forgotPasswordBean.getEmail());
    if (forgotPasswordOptional.isPresent()) {
      try {
        mailService.sendForgotPasswordEmail(forgotPasswordBean.getEmail(), forgotPasswordOptional.get().getForgotPasswordKey());
        LOGGER.info("Mail is sent to = " + forgotPasswordBean.getEmail());
        return success();
      } catch (Exception e) {
        LOGGER.error(e.getMessage(), e);
      }
    }
    return bad();
  }

  @RequestMapping(value = "/reset-password/{forgotPasswordKey}", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity resetPassword(@PathVariable(value = "forgotPasswordKey") String forgotPasswordKey,
                                         @RequestBody @Valid ResetPasswordBean resetPasswordBean, BindingResult result) {
    if (result.hasErrors()) {
      return incorrect();
    }

    passwordService.useForgotPassword(forgotPasswordKey, resetPasswordBean.getPassword());
    return success();
  }
}
