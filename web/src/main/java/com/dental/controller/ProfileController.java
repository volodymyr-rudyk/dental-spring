package com.dental.controller;

import com.dental.exception.NotFoundException;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.Dentist;
import com.dental.service.DentistService;
import com.dental.view.ViewConfig;
import com.dental.view.ViewFolderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vrudyk on 12/19/2015.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractBasePageController {

  @Autowired
  private DentistService dentistService;

  @RequestMapping(method = RequestMethod.GET)
  public String profile(@LoggedDentist Dentist loggedDentist, ModelMap model) throws NotFoundException {
    Dentist dentist = dentistService.getFull(loggedDentist.getId());
    model.put("dentist", dentist);
    return renderView(ViewConfig.PAGE_PROFILE);
  }

  @Override
  protected String getViewFolder() {
    return ViewFolderConfig.FOLDER_PROFILE;
  }
}
