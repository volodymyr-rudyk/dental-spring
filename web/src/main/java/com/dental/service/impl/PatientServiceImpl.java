package com.dental.service.impl;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.helperbean.Gender;
import com.dental.persistence.repository.PatientRepository;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.PatientDTO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by vrudyk on 3/22/2016.
 */
@Service
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
    if (dentistBean == null) return Collections.emptyList();
    Collection<Patient> patients = patientRepository.getPatientsByDentist(dentistBean.getId());
    return patients;
  }

  @Override
  public Patient get(Long id) {
    return patientRepository.get(id);
  }

  @Override
  @Transactional
  public boolean update(PatientDTO patientDTO, Dentist loggedInDentist) {
    Collection<Patient> patients = patientRepository.getPatientsByDentist(loggedInDentist.getId());
    Optional<Patient> optional = patients.stream().filter((p) -> p.getId().equals(patientDTO.getId())).findFirst();
    optional.ifPresent(p -> {
      p.setFirstName(patientDTO.getFirstName());
      p.setLastName(patientDTO.getLastName());
      p.setMiddleName(patientDTO.getMiddleName());
      p.setMiddleName(patientDTO.getMiddleName());
      p.setAddress(patientDTO.getAddress());
      p.setBirthday(patientDTO.getBirthday());
      p.setGender(Gender.get(patientDTO.getGender()));
      p.setPhone(patientDTO.getPhone());
      patientRepository.update(p);
    });
    return true;
  }

  @Override
  public void add(PatientDTO patientDTO, Dentist dentist) {
    Patient patient = DTOUtils.convert(patientDTO);
    patient.getDentists().add(dentist);
    patientRepository.save(patient);
  }

  @Override
  @Transactional
  public void add(Patient patient) {
    Dentist loggedInDentist = dentistService.getLoggedInDentist();
    Dentist dentist = dentistService.get(loggedInDentist.getId());
    Hibernate.initialize(dentist.getPatients());
    dentist.getPatients().add(patient);
    dentistService.save(dentist);
  }
}
