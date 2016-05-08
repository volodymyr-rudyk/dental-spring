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
 * Created by admin on 26.05.2015.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardPageController extends AbstractBasePageController {

  public static final String DASHBOARD_VIEW = "dashboard";

  @Autowired
  private DentistService dentistService;

  @RequestMapping(method = RequestMethod.GET)
  public String dashboard(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws NotFoundException {
    Dentist loggedInDentist = dentistService.getLoggedInDentist();
    Dentist dentist = dentistService.getFull(loggedInDentist.getId());
    model.put("dentist", dentist);
    return renderView(DASHBOARD_VIEW);
  }

  @Override
  protected String getViewFolder() {
    return ViewConfig.FOLDER_DASHBOARD;
  }
}
