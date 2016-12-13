package com.dntistpro.web.rest;

import com.dntistpro.web.request.legacy.ToothStateBean;
import com.dntistpro.exception.EntityNotFountException;
import com.dntistpro.init.LoggedDentist;
import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.PatientEntity;
import com.dntistpro.service.AuthService;
import com.dntistpro.service.DentistService;
import com.dntistpro.service.PatientService;
import com.dntistpro.service.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by light on 4/7/2015.
 */
@RestController
public class ToothRestController extends BaseRestController {

  @Autowired
  protected AuthService authService;

  @Autowired
  private ToothService toothService;

  @Autowired
  private DentistService dentistService;

  @Autowired
  private PatientService patientService;

  @RequestMapping(value = "/tooth/state", method = RequestMethod.PUT,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> toothStatePut(@LoggedDentist DentistEntity loggedDentist,
                                         @RequestBody ToothStateBean toothStateBean)  {
    PatientEntity patient = patientService.findByDentistIdAndPatientId(loggedDentist.getId(), toothStateBean.getPatientId());
    if (patient == null) {
      throw new EntityNotFountException("Patient entity not found");
    }
    toothService.updateToothState(toothStateBean.getToothId(), toothStateBean.ToothState());
    return success();
  }
}