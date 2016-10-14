package com.dental.web.rest;

import com.dental.bean.request.ToothStateBean;
import com.dental.exception.EntityNotFountException;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.PatientEntity;
import com.dental.service.AuthService;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.service.ToothService;
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