package com.dental.web.rest;

import com.dental.bean.SigninBean;
import com.dental.bean.SignupBean;
import com.dental.provider.DentalUserDetails;
import com.dental.service.AuthService;
import com.dental.spring.EventService;
import com.dental.spring.LoginEvent;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.SigninDTO;
import com.dental.web.dto.SignupDTO;
import com.dental.web.error.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by vrudyk on 11/3/2015.
 */
@RestController
public class AuthRestController extends BaseRestController {

  private Logger LOG = LoggerFactory.getLogger(AuthRestController.class);

  @Autowired
  private EventService eventService;

  @Autowired
  private AuthService authService;

  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> login(HttpServletRequest httpServletRequest,
                                                   @RequestBody @Valid SigninBean signinBean, BindingResult result) {
    if (result.hasErrors()) return incorrect();

    try {
      UserDetails userDetails = authService.authenticate(signinBean, httpServletRequest);
      DentalUserDetails dentalUserDetails = (DentalUserDetails) userDetails;
      SigninDTO signinDTO = DTOUtils.convert(dentalUserDetails);

      eventService.publish(new LoginEvent(this, signinBean.getEmail()));
      return success(signinDTO);
    } catch (AuthenticationException e) {
      LOG.error("Authentication Error", e.getMessage());
      return bad();
    } catch (Exception e) {
      LOG.error("Error", e.getMessage());
      return bad();
    }
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> signup(HttpServletRequest httpServletRequest,
                                                  @RequestBody @Valid SignupBean signupBean, BindingResult result) {

    if (result.hasErrors()) return bad(RestStatus.SINGUP_ERROR);

    try {
      authService.signup(signupBean);
      SignupDTO signupDTO = new SignupDTO();
      signupDTO.setEmail(signupBean.getEmail());
      return success(signupDTO);
    } catch (Exception e) {
      LOG.error("Signup Error", e.getMessage());
      return bad();
    }
  }

  @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    authService.logout(httpServletRequest, httpServletResponse);
    return success();
  }

}