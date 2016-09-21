package com.dental.web.rest;

import com.dental.bean.DentistBean;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.Dentist;
import com.dental.service.DentistService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.ProfileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by light on 12/5/2015.
 */
@RestController
public class ProfileRestController extends BaseRestController {

  private static final Logger LOG = LoggerFactory.getLogger(PasswordRestController.class);

  @Autowired
  private DentistService dentistService;

  @RequestMapping(value = "/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.ALL_VALUE)
  public ResponseEntity<?> profileGet(HttpServletRequest httpServletRequest, @LoggedDentist Dentist loggedDentist) {
    Dentist dentist = dentistService.get(loggedDentist.getId());
    ProfileDTO profileDTO = DTOUtils.convertToProfile(dentist);

    return success(profileDTO);
  }

  @RequestMapping(value = "/profile", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> profilePut(HttpServletRequest httpServletRequest, @LoggedDentist Dentist loggedDentist,
                                      @RequestBody DentistBean dentistBean) {
    Dentist dentist = dentistService.get(loggedDentist.getId());
    dentistService.update(dentistBean, dentist);
    LOG.info("Profile updated ...");
    return success();
  }

}