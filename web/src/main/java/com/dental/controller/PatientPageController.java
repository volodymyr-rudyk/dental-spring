package com.dental.controller;

import com.dental.exception.NotFoundException;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.Dentist;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.view.ViewConfig;
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
@RequestMapping("/dashboard/patient")
public class PatientPageController extends AbstractBasePageController {

  public static final String VIEW_FOLDER = "patient";

  @Autowired
  private PatientService patientService;

  @Autowired
  private DentistService dentistService;

  @RequestMapping(method = RequestMethod.GET)
  public String patient(@LoggedDentist Dentist loggedDentist, ModelMap model) throws NotFoundException {
    Dentist dentist = dentistService.getFull(loggedDentist.getId());
    model.put("dentist", dentist);
    return renderView("list");
  }

  @Override
  protected String getViewFolder() {
    return ViewConfig.FOLDER_PATIENT;
  }
}
