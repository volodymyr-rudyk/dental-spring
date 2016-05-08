package com.dental.web.rest;

import com.dental.service.DentistService;
import com.dental.web.dto.SigninDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by light on 12/5/2015.
 */
@RestController
public class DashboardRestController extends BaseRestController {

  @Autowired
  private DentistService dentistService;

  @RequestMapping(value = "/dashboard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<? extends SigninDTO> dashboard(HttpServletRequest httpServletRequest) {

    return null;
  }

}