package com.dntistpro.web.rest;

import com.dntistpro.init.LoggedDentist;
import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.service.DentistService;
import com.dntistpro.service.PatientService;
import com.dntistpro.service.ToothService;
import com.dntistpro.web.dto.DTOUtils;
import com.dntistpro.web.dto.DashboardDTO;
import com.dntistpro.web.dto.DentistDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
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

  @ApiOperation(value = "Get list of tenant's resources.", authorizations = @Authorization(value = "user"))
  @RequestMapping(value = "/dashboard", method = RequestMethod.GET , consumes = MediaType.ALL_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> dashboard(/*@LoggedDentist DentistEntity loggedDentist*/) {
    long id = 1l;
    DentistEntity dentist = dentistService.get(id);
    Long patientsCount = patientService.patientsCount(id);
    LOG.info("patients for dentist " + patientsCount);
    Long curesCount = toothService.countCuresByDentistId(id);
    LOG.info("cures for dentist " + curesCount);
    DentistDTO dentistDTO = DTOUtils.convert(dentist);

    DashboardDTO dashboardDTO = new DashboardDTO();
    dashboardDTO.setPatientsCount(patientsCount);
    dashboardDTO.setDentist(dentistDTO);
    dashboardDTO.setCuresCount(curesCount);
    return success(dashboardDTO);
  }

}