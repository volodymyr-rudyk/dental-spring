package com.dental.controller;

import com.dental.exception.NotFoundException;
import com.dental.persistence.entity.Dentist;
import com.dental.service.DentistService;
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

  @Autowired
  private DentistService dentistService;

  @RequestMapping(method = RequestMethod.GET)
  public String profile(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws NotFoundException {
    Dentist loggedInDentist = dentistService.getLoggedInDentist();
    assert loggedInDentist != null;
    loggedInDentist.getUser();
    model.put("dentist", loggedInDentist);
    return renderView(PAGE_PROFILE);
  }

  @Override
  protected String getViewFolder() {
    return ViewConfig.FOLDER_PROFILE;
  }
}
