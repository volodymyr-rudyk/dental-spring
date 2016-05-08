package com.dental.service.impl;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.repository.PatientRepository;
import com.dental.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by vrudyk on 3/22/2016.
 */
@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  private PatientRepository patientRepository;

  @Override
  public Patient get(String firstName, String lastName) {
    return patientRepository.findByFirstAndLastName(firstName, lastName);
  }

  @Override
  public Collection<Patient> getList(Dentist dentistBean) {
    if(dentistBean == null) return Collections.emptyList();
    Collection<Patient> patients = patientRepository.getPatientsByDentist(dentistBean.getId());
    return patients;
  }

  @Override
  public Patient get(Long id) {
    return patientRepository.get(id);
  }
}
