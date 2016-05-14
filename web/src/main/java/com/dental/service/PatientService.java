package com.dental.service;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.web.dto.PatientDTO;

import java.util.Collection;

/**
 * Created by vrudyk on 3/21/2016.
 */
public interface PatientService extends BaseService<Patient> {
  Patient get(String firstName, String lastName);

  Collection<Patient> getList(Dentist dentist);

  boolean update(Long id, Dentist loggedInDentist);

  void add(PatientDTO patientDTO, Dentist dentist);

  void add(Patient patient);
}
