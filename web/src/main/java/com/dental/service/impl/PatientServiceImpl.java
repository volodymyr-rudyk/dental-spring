package com.dental.service.impl;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.repository.PatientRepository;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by vrudyk on 3/22/2016.
 */
public class PatientServiceImpl implements PatientService {

  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private DentistService dentistService;

  @Override
  public Patient get(String firstName, String lastName) {
    return patientRepository.findByFirstAndLastName(firstName, lastName);
  }

  @Override
  public Collection<Patient> getList(Dentist dentistBean) {
    if(dentistBean == null) return Collections.emptyList();
    Dentist dentist = dentistService.get(dentistBean.getId());
    Set<Patient> patients = dentist.getPatients();
    Hibernate.initialize(patients);
    return patients;
  }

  @Override
  public Patient get(Long id) {
    return patientRepository.get(id);
  }
}
