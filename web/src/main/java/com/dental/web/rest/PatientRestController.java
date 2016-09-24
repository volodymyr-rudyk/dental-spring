package com.dental.web.rest;

import com.dental.bean.ToothCureRequestBean;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.entity.Tooth;
import com.dental.persistence.entity.ToothCure;
import com.dental.service.AuthService;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.service.ToothService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.PatientDTO;
import com.dental.web.dto.ToothCureDTO;
import com.dental.web.dto.ToothDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by light on 12/5/2015.
 */
@RestController
public class PatientRestController extends BaseRestController {

  @Autowired
  protected AuthService authService;

  @Autowired
  private DentistService dentistService;

  @Autowired
  private PatientService patientService;

  @Autowired
  private ToothService toothService;

  @RequestMapping(value = "/patients", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Set<PatientDTO>> getPatients(HttpServletRequest httpServletRequest,
                                                     @LoggedDentist Dentist loggedDentist, @PageableDefault(size = 7) Pageable page) {
    Set<Patient> patients = patientService.findAllByDentist(loggedDentist);
    Set<PatientDTO> patientsDTO = DTOUtils.convert(patients);
    ResponseEntity<Set<PatientDTO>> responseEntity = new ResponseEntity<>(patientsDTO, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Long patientId, @LoggedDentist Dentist loggedDentist) {
    Patient patient = patientService.load(patientId);
    PatientDTO patientDTO = DTOUtils.convertDeep(patient);
    return success(patientDTO);
  }

  @RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> putPatient(HttpServletRequest httpServletRequest, @RequestBody PatientDTO patientDTO) {

    Dentist loggedInDentist = authService.getLoggedInDentist();
    patientService.update(patientDTO, loggedInDentist);
    return success();
  }

  @RequestMapping(value = "/patients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> patient(HttpServletRequest httpServletRequest, @RequestBody PatientDTO patientDTO) {

    Patient patient = DTOUtils.convert(patientDTO);
    patient = patientService.add(patient);
    PatientDTO convert = DTOUtils.convert(patient);
    return success(convert);
  }

  @RequestMapping(value = "/patients/{id}/teeth/{toothId}/cures", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getToothCures(@PathVariable("id") Long patientId, @PathVariable("toothId") Long toothId ) {
    Tooth tooth = toothService.load(toothId, patientId);
    ToothDTO toothDTO = DTOUtils.convertDeep(tooth);
    return success(toothDTO);
  }

  @RequestMapping(value = "/patients/{id}/teeth/{toothId}/cures", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addToothCure(HttpServletRequest httpServletRequest, @LoggedDentist Dentist loggedDentist,
                                                     @RequestBody ToothCureRequestBean toothCureRequestBean)  {
    ToothCure toothCure = new ToothCure(toothCureRequestBean.getCure());
    toothCure = toothService.addCure(toothCure, toothCureRequestBean.getToothId(), toothCureRequestBean.getPatientId());
    ToothCureDTO toothCureDTO = DTOUtils.convert(toothCure);
    return new ResponseEntity<>(toothCureDTO, HttpStatus.CREATED);
  }

}