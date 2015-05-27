package com.dental.controller.profile;

import com.dental.controller.BaseController;
import com.dental.provider.DentalUserDetails;
import com.dental.service.ProfileService;
import com.dental.view.ViewConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 26.05.2015.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController extends BaseController {

  @Autowired
  private ProfileService profileService;

  @RequestMapping
  public String profile(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
    DentalUserDetails dentalUserDetails = (DentalUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.put("profile", dentalUserDetails.getUser().getProfile());
    return renderView("profile");
  }

  @RequestMapping("/edit")
  public String editProfile() {
    return renderView("edit");
  }

  @RequestMapping("/save")
  public String saveProfile() {
    return renderView("profile");
  }

  @Override protected String getViewFolder() {
    return ViewConfig.FOLDER_PROFILE;
  }
}
