package com.dental.service;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.web.dto.PatientDTO;

import java.util.Collection;
import java.util.Set;

/**
 * Created by vrudyk on 3/21/2016.
 */
public interface PatientService extends BaseService<Patient> {
  Patient get(String firstName, String lastName);

  Patient getFull(Long patientId);

  Collection<Patient> getList(Dentist dentist);

  boolean update(PatientDTO patientDTO, Dentist loggedInDentist);

  void add(PatientDTO patientDTO, Dentist dentist);

  void add(Patient patient);

  Patient findIn(Long patientId, Set<Patient> patients);
}
