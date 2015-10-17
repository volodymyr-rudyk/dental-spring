package com.dental.controller;

import com.dental.dao.entity.Profile;
import com.dental.exception.NotFoundException;
import com.dental.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 26.05.2015.
 */
@RestController
public class SearchController extends BaseController {

  public static final String PROFILE_VIEW = "profile";

  private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);

  @Autowired
  private ProfileService profileService;

  @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST}
//          produces = "application/json",  consumes = "*/*"
  )
  public Profile search(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam("q") String query, ModelMap model) throws NotFoundException {
    LOG.info("query = " + query);
    Profile profile = profileService.getProfile(1);

//    return new ResponseEntity<>(profile, HttpStatus.OK);
    return profile;
  }

  @Override
  protected String getViewFolder() {
    return null;
  }
}