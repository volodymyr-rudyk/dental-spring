package com.dental.controller;

import com.dental.exception.NotFoundException;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.Dentist;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.view.ViewConfig;
import com.dental.view.ViewFolderConfig;
import com.dental.web.rest.PasswordRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 26.05.2015.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardPageController extends AbstractBasePageController {

  private Logger LOG = LoggerFactory.getLogger(PasswordRestController.class);


  @Autowired
  private DentistService dentistService;

  @Autowired
  private PatientService patientService;

  @RequestMapping(method = RequestMethod.GET)
  public String dashboard(HttpServletRequest request, HttpServletResponse response, @LoggedDentist Dentist loggedDentist,
                          ModelMap model) throws NotFoundException {

    Long patientsCount = patientService.patientsCount(loggedDentist.getId());
    LOG.info("patients for dentist " + patientsCount);


    Dentist dentist = dentistService.load(loggedDentist.getId());
    model.put("dentist", dentist);
    return renderView(ViewConfig.PAGE_DASHBOARD);
  }

  @Override
  protected String getViewFolder() {
    return ViewFolderConfig.FOLDER_DASHBOARD;
  }
}
