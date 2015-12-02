package com.dental.web.rest;

import com.dental.bean.UserBean;
import com.dental.service.AuthService;
import com.dental.web.ResponseStatus;
import com.dental.web.dto.SigninDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

  private Logger logger = LoggerFactory.getLogger(AuthRestController.class);

  @Autowired
  private AuthService authService;

  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SigninDTO> login(HttpServletRequest httpServletRequest, @RequestBody @Valid UserBean userBean,
                                         BindingResult result) {

    SigninDTO signinDTO = new SigninDTO();
    if (result.hasErrors()) {
      signinDTO.setCode(-1);
      signinDTO.setResponseStatus(ResponseStatus.Failure);
      signinDTO.setMessage("Invalid user data");
      return new ResponseEntity<>(signinDTO, HttpStatus.BAD_REQUEST);
    }

    try {
      authService.authenticate(userBean, httpServletRequest);
      signinDTO.setCode(200);
      signinDTO.setResponseStatus(ResponseStatus.Success);
      signinDTO.setUserEmail(userBean.getEmail());
      return new ResponseEntity<>(signinDTO, HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Authentication Error", e.getMessage());
      signinDTO.setCode(-1);
      signinDTO.setMessage("Invalid user data");
      signinDTO.setResponseStatus(ResponseStatus.Failure);
      return new ResponseEntity<>(signinDTO, HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SigninDTO> signup(HttpServletRequest httpServletRequest, @RequestBody @Valid UserBean userBean,
                                         BindingResult result) {



    return null;
  }

  @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    authService.logout(httpServletRequest, httpServletResponse);
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Node> js() {
    return new ResponseEntity<>(new Node(), HttpStatus.OK);
  }

  @RequestMapping(value = "/test2", method = RequestMethod.GET, produces = "application/json")
  public Node js2() {
    return new Node();
  }

  @RequestMapping(value = "/test3", method = RequestMethod.GET)
  public Node js3() {
    return new Node();
  }

  private static class Node {
    private String s1 = "test1";
    private String s2 = "test2";
    private String s3 = "test3";

    public String getS1() {
      return s1;
    }

    public void setS1(String s1) {
      this.s1 = s1;
    }

    public String getS2() {
      return s2;
    }

    public void setS2(String s2) {
      this.s2 = s2;
    }

    public String getS3() {
      return s3;
    }

    public void setS3(String s3) {
      this.s3 = s3;
    }
  }

}