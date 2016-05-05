package com.dental.controller;

import com.dental.exception.NotFoundException;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
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
import java.util.Collection;

/**
 * Created by admin on 26.05.2015.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardPageController extends AbstractBasePageController {

  public static final String DASHBOARD_VIEW = "dashboard";

  @Autowired
  private DentistService dentistService;

  @Autowired
  private PatientService patientService;

  @RequestMapping(method = RequestMethod.GET)
  public String dashboard(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws NotFoundException {
    Dentist loggedInDentist = dentistService.getLoggedInDentist();
    assert loggedInDentist != null;
    Collection<Patient> patients = patientService.getList(loggedInDentist);
    model.put("dentist", loggedInDentist);
    model.put("patients", patients);
    return renderView(DASHBOARD_VIEW);
  }

  @Override
  protected String getViewFolder() {
    return ViewConfig.FOLDER_DASHBOARD;
  }
}
