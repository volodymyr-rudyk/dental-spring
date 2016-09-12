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
import com.dental.web.status.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    } catch (Exception e) {
      LOG.error("Authentication Error", e.getMessage());
      return bad();
    }
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<? extends SignupDTO> signup(HttpServletRequest httpServletRequest,
                                                    @RequestBody @Valid SignupBean signupBean, BindingResult result) {

    SignupDTO signupDTO;
    if (result.hasErrors()) {
      signupDTO = new SignupDTO(baseDTO(ResponseStatus.Failure, RestStatus.SINGUP_ERROR));
      return new ResponseEntity<>(signupDTO, HttpStatus.BAD_REQUEST);
    }

    try {
      authService.signup(signupBean);
      signupDTO = new SignupDTO(baseDTO(ResponseStatus.Success, RestStatus.SUCCESS));
      signupDTO.setEmail(signupBean.getEmail());
      return new ResponseEntity<>(signupDTO, HttpStatus.OK);
    } catch (Exception e) {
      LOG.error("Signup Error", e.getMessage());
      signupDTO = new SignupDTO(baseDTO(ResponseStatus.Failure, RestStatus.SINGUP_ERROR));
      return new ResponseEntity<>(signupDTO, HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    authService.logout(httpServletRequest, httpServletResponse);
    return success();
  }

}