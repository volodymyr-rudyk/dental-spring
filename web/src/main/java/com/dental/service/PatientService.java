package com.dental.service;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.web.dto.PatientDTO;

import java.util.Set;

/**
 * Created by vrudyk on 3/21/2016.
 */
public interface PatientService extends BaseService<Patient> {
  Patient findByFirstNameAndLastName(String firstName, String lastName);

  Patient load(Long patientId);

  boolean update(PatientDTO patientDTO, Dentist loggedInDentist);

  void add(PatientDTO patientDTO, Dentist dentist);

  void add(Patient patient);

  Patient findIn(Long patientId, Set<Patient> patients);
}
