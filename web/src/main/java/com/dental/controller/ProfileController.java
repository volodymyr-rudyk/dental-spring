package com.dental.controller;

import com.dental.exception.NotFoundException;
import com.dental.persistence.entity.Profile;
import com.dental.service.ProfileService;
import com.dental.view.ViewConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vrudyk on 12/19/2015.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractBasePageController {

  public static final String PROFILE_VIEW = "profile";

  @Autowired
  private ProfileService profileService;

  @RequestMapping(method = RequestMethod.GET)
  public String profile(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws NotFoundException {
    Profile loggedInProfile = profileService.getLoggedInProfile();
    assert loggedInProfile != null;
    loggedInProfile.getUser();
    model.put("profile", loggedInProfile);
    return renderView(PROFILE_VIEW);
  }

  @Override
  protected String getViewFolder() {
    return ViewConfig.FOLDER_PROFILE;
  }
}
