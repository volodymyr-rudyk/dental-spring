package com.dental.service.impl;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.DentistPatient;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.entity.Tooth;
import com.dental.persistence.helperbean.Gender;
import com.dental.persistence.helperbean.ToothBucket;
import com.dental.persistence.helperbean.ToothState;
import com.dental.persistence.repository.DentistPatientRepository;
import com.dental.persistence.repository.PatientRepository;
import com.dental.service.AuthService;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.PatientDTO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vrudyk on 3/22/2016.
 */
@Service
public class PatientServiceImpl implements PatientService {

  private static final int TEETH_IN_BUCKET = 8;
  @Autowired
  private AuthService authService;
  @Autowired
  private PatientRepository patientRepository;
  @Autowired
  private DentistPatientRepository dentistPatientRepository;

  @Autowired
  private DentistService dentistService;

  @Override
  public Patient findByFirstNameAndLastName(String firstName, String lastName) {
    return patientRepository.findByFirstNameAndLastName(firstName, lastName);
  }

  @Override
  @Transactional
  public Patient load(Long patientId) {
    Patient patient = patientRepository.findOne(patientId);
    Hibernate.initialize(patient.getTeeth());
    return patient;
  }

  @Override
  public Patient get(Long id) {
    return patientRepository.findOne(id);
  }

  @Override
  @Transactional
  public boolean update(PatientDTO patientDTO, Dentist loggedInDentist) {
    Patient patient = patientRepository.findOne(patientDTO.getId());
    patient.setFirstName(patientDTO.getFirstName());
    patient.setMiddleName(patientDTO.getMiddleName());
    patient.setLastName(patientDTO.getLastName());
    patient.setAddress(patientDTO.getAddress());
    patient.setBirthday(patientDTO.getBirthday());
    patient.setPhone(patientDTO.getPhone());
    patient.setGender(Gender.get(patientDTO.getGender()));
    patientRepository.save(patient);
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
  public Patient add(Patient patient) {
    Dentist loggedInDentist = authService.getLoggedInDentist();
    Dentist dentist = dentistService.get(loggedInDentist.getId());
    Set<Tooth> teeth = patient.getTeeth();

    for(int i = 1; i <= TEETH_IN_BUCKET; i++) {
      fillTeeth(i, ToothBucket.UP_LEFT, teeth);
    }

    for(int i = 1; i <= TEETH_IN_BUCKET; i++) {
      fillTeeth(i, ToothBucket.UP_RIGHT, teeth);
    }

    for(int i = 1; i <= TEETH_IN_BUCKET; i++) {
      fillTeeth(i, ToothBucket.DOWN_LEFT, teeth);
    }

    for(int i = 1; i <= TEETH_IN_BUCKET; i++) {
      fillTeeth(i, ToothBucket.DOWN_RIGHT, teeth);
    }

    teeth.stream().forEach(t -> {
      t.setPatient(patient);
      t.setToothState(ToothState.UNDEFINED);
    });


    Patient p = patientRepository.save(patient);
    DentistPatient dentistPatient = new DentistPatient();
    dentistPatient.setDentist(dentist);
    dentistPatient.setPatient(p);
    dentistPatientRepository.save(dentistPatient);

    return patient;
  }

  private void fillTeeth(int index, ToothBucket toothBucket, Set<Tooth> teeth) {
    Tooth tooth = new Tooth();
    tooth.setToothBucket(toothBucket);
    tooth.setToothNumber(index);
    teeth.add(tooth);
  }

  @Override
  public Patient findByDentist(Dentist dentist) {
    return patientRepository.findByDentists(dentist);
  }

  @Override
  public Set<Patient> findByDentist(Dentist dentist, Pageable page) {
    return new HashSet<>(patientRepository.findByDentists(dentist, page));
  }

  @Override
  public Set<Patient> findAllByDentist(Dentist dentist) {
    return new HashSet<>(patientRepository.findAllByDentists(dentist));
  }

  @Override
  public Long patientsCount(Long dentistId) {
    return patientRepository.countByDentistsId(dentistId);
  }
}
