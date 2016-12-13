package com.dntistpro.web.rest;

import com.dntistpro.web.request.legacy.DentistBean;
import com.dntistpro.web.request.legacy.LanguageBean;
import com.dntistpro.init.LoggedDentist;
import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.UserEntity;
import com.dntistpro.service.DentistService;
import com.dntistpro.service.UserService;
import com.dntistpro.web.dto.DTOUtils;
import com.dntistpro.web.dto.ProfileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by light on 12/5/2015.
 */
@RestController
public class ProfileRestController extends BaseRestController {

  private static final Logger LOG = LoggerFactory.getLogger(PasswordRestController.class);

  @Autowired
  private DentistService dentistService;

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.ALL_VALUE)
  public ResponseEntity<?> profileGet(HttpServletRequest httpServletRequest, @LoggedDentist DentistEntity loggedDentist) {
    DentistEntity dentist = dentistService.get(loggedDentist.getId());
    ProfileDTO profileDTO = DTOUtils.convertToProfile(dentist);

    return success(profileDTO);
  }

  @RequestMapping(value = "/profile", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> profilePut(HttpServletRequest httpServletRequest, @LoggedDentist DentistEntity loggedDentist,
                                      @RequestBody DentistBean dentistBean) {
    DentistEntity dentist = dentistService.get(loggedDentist.getId());
    dentistService.update(dentistBean, dentist);
    LOG.info("Profile updated ...");
    return success();
  }

  @RequestMapping(value = "/profile/language", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> profileLanguagePut(HttpServletRequest httpServletRequest,
                                              @LoggedDentist DentistEntity loggedDentist,
                                              @RequestBody LanguageBean languageBean) {
    UserEntity user = dentistService.get(loggedDentist.getId()).getUser();
    userService.updateLanguage(user, languageBean.getLanguage());
    return success();
  }
}