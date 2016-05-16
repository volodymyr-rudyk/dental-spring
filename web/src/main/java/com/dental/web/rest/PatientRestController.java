package com.dental.web.rest;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.DentistDTO;
import com.dental.web.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by light on 12/5/2015.
 */
@RestController
public class PatientRestController extends BaseRestController {

  @Autowired
  private DentistService dentistService;

  @Autowired
  private PatientService patientService;

  @RequestMapping(value = "/patient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DentistDTO> getPatients(HttpServletRequest httpServletRequest) {
    Dentist loggedInDentist = dentistService.getLoggedInDentist();
    Dentist dentist = dentistService.getFull(loggedInDentist.getId());
    DentistDTO dentistDTO = DTOUtils.convert(dentist);
    ResponseEntity<DentistDTO> responseEntity = new ResponseEntity<DentistDTO>(dentistDTO, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Long patientId) {
    Dentist loggedInDentist = dentistService.getLoggedInDentist();
    Patient patient = patientService.get(patientId);
    PatientDTO patientDTO = DTOUtils.convert(patient);
    ResponseEntity<PatientDTO> responseEntity = new ResponseEntity<>(patientDTO, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(value = "/patient/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> putPatient(HttpServletRequest httpServletRequest, PatientDTO patientDTO) {

    Dentist loggedInDentist = dentistService.getLoggedInDentist();
    patientService.update(patientDTO, loggedInDentist);

    ResponseEntity<Object> responseEntity = new ResponseEntity<>(null, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(value = "/patient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> patient(HttpServletRequest httpServletRequest, @RequestBody PatientDTO patientDTO) {

    Patient patient = DTOUtils.convert(patientDTO);
    patientService.add(patient);
    ResponseEntity responseEntity = new ResponseEntity(null, HttpStatus.OK);
    return responseEntity;
  }

}