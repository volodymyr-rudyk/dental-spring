package com.dental.web.rest;

import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.DentistEntity;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.service.ToothService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.DashboardDTO;
import com.dental.web.dto.DentistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by light on 12/5/2015.
 */
@RestController
public class DashboardRestController extends BaseRestController {

  private Logger LOG = LoggerFactory.getLogger(PasswordRestController.class);

  @Autowired
  private DentistService dentistService;

  @Autowired
  private PatientService patientService;

  @Autowired
  private ToothService toothService;

  @RequestMapping(value = "/dashboard", method = RequestMethod.GET , consumes = MediaType.ALL_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> dashboard(@LoggedDentist DentistEntity loggedDentist) {
    DentistEntity dentist = dentistService.get(loggedDentist.getId());
    Long patientsCount = patientService.patientsCount(loggedDentist.getId());
    LOG.info("patients for dentist " + patientsCount);
    Long curesCount = toothService.countCuresByDentistId(loggedDentist.getId());
    LOG.info("cures for dentist " + curesCount);
    DentistDTO dentistDTO = DTOUtils.convert(dentist);

    DashboardDTO dashboardDTO = new DashboardDTO();
    dashboardDTO.setPatientsCount(patientsCount);
    dashboardDTO.setDentist(dentistDTO);
    dashboardDTO.setCuresCount(curesCount);
    return success(dashboardDTO);
  }

}