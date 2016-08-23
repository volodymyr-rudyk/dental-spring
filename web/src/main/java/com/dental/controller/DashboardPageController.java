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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 26.05.2015.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardPageController extends AbstractBasePageController {


  @Autowired
  private DentistService dentistService;

  @RequestMapping(method = RequestMethod.GET)
  public String dashboard(HttpServletRequest request, HttpServletResponse response, @LoggedDentist Dentist loggedDentist,
                          ModelMap model) throws NotFoundException {
    Dentist dentist = dentistService.load(loggedDentist.getId());
    model.put("dentist", dentist);
    return renderView(ViewConfig.PAGE_DASHBOARD);
  }

  @Override
  protected String getViewFolder() {
    return ViewFolderConfig.FOLDER_DASHBOARD;
  }
}
