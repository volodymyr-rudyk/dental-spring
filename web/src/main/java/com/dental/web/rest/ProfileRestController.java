package com.dental.web.rest;

import com.dental.bean.ProfileBean;
import com.dental.persistence.entity.Profile;
import com.dental.service.ProfileService;
import com.dental.web.ResponseStatus;
import com.dental.web.dto.BaseDTO;
import com.dental.web.dto.ProfileDTO;
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
import javax.validation.Valid;

/**
 * Created by vrudyk on 12/14/2015.
 */
@RestController
@RequestMapping("/profile")
public class ProfileRestController extends BaseRestController {

  @Autowired
  private ProfileService profileService;

  @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<? extends BaseDTO> signup(HttpServletRequest httpServletRequest,
                                                  @RequestBody @Valid ProfileBean profileBean,
                                                  BindingResult result) {

    if (result.hasErrors()) {
      ProfileDTO profileDTO = new ProfileDTO();
      profileDTO.setResponseStatus(ResponseStatus.Failure);
      profileDTO.setCode(-1);
      profileDTO.setMessage("Incorrect user profile data");
      return new ResponseEntity<>(profileDTO, HttpStatus.BAD_REQUEST);
    }
    Profile profile = profileService.getLoggedInProfile();
    assert profile != null;
    profileService.update(profileBean, profile);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
