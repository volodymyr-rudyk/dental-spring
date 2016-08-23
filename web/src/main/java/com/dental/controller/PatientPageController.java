package com.dental.controller;

import com.dental.exception.NotFoundException;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.Dentist;
import com.dental.service.DentistService;
import com.dental.view.ViewConfig;
import com.dental.view.ViewFolderConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 26.05.2015.
 */
@Controller
@RequestMapping("/dashboard/patient")
public class PatientPageController extends AbstractBasePageController {

  public static final Logger LOG = LoggerFactory.getLogger(PatientPageController.class);

  @Autowired
  private DentistService dentistService;

  @RequestMapping(method = RequestMethod.GET)
  public String patient(@LoggedDentist Dentist loggedDentist, ModelMap model) throws NotFoundException {
    Dentist dentist = dentistService.load(loggedDentist.getId());
    model.put("dentist", dentist);
    LOG.info("patient page rendered");
    return renderView(ViewConfig.PAGE_PATIENT_LIST);
  }

  @Override
  protected String getViewFolder() {
    return ViewFolderConfig.FOLDER_PATIENT;
  }
}
