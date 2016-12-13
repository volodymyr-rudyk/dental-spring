package com.dntistpro.web.rest;

import com.dntistpro.service.AuthService;
import com.dntistpro.spring.EventService;
import com.dntistpro.spring.LoginEvent;
import com.dntistpro.web.dto.SigninDTO;
import com.dntistpro.web.dto.SignupDTO;
import com.dntistpro.web.error.RestStatus;
import com.dntistpro.web.request.LoginRequest;
import com.dntistpro.web.request.legacy.SignupBean;
import com.dntistpro.web.response.LoginResponse;
import com.dntistpro.web.response.Response;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
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
@Api(value = "/", description = "Authentication Service.")
@RestController
public class AuthRestController extends BaseRestController {

  private Logger LOG = LoggerFactory.getLogger(AuthRestController.class);

  @Autowired
  private EventService eventService;

  @Autowired
  private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        @RequestBody @Valid LoginRequest loginRequest, BindingResult result) {
    if (result.hasErrors()) return incorrect();

    try {
      String token = authService.authenticateToken(loginRequest, httpServletRequest, httpServletResponse);

      LoginResponse response = new LoginResponse();
      response.setToken(token);
      eventService.publish(new LoginEvent(this, loginRequest.getEmail()));
      return ResponseEntity.ok(response);
    } catch (AuthenticationException e) {
      LOG.error("Authentication Error", e.getMessage());
      return incorrect();
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