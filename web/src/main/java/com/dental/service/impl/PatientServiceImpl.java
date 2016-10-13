package com.dental.service.impl;

import com.dental.exception.EntityNotFountException;
import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.DentistPatient;
import com.dental.persistence.entity.PatientEntity;
import com.dental.persistence.entity.ToothEntity;
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
import java.util.List;
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
  public PatientEntity findByFirstNameAndLastName(String firstName, String lastName) {
    return patientRepository.findByFirstNameAndLastName(firstName, lastName);
  }

  @Override
  @Transactional
  public PatientEntity load(Long patientId) {
    PatientEntity patient = patientRepository.findOne(patientId);
    Hibernate.initialize(patient.getTeeth());
    return patient;
  }

  @Override
  public PatientEntity get(Long id) {
    return patientRepository.findOne(id);
  }

  @Override
  @Transactional
  public boolean update(PatientDTO patientDTO, DentistEntity loggedInDentist) {
    PatientEntity patient = patientRepository.findOne(patientDTO.getId());
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
  public void add(PatientDTO patientDTO, DentistEntity dentist) {
    PatientEntity patient = DTOUtils.convert(patientDTO);
    patient.getDentists().add(dentist);
    patientRepository.save(patient);
  }

  @Override
  public List<PatientEntity> findByDentist(DentistEntity dentist) {
    return patientRepository.findByDentists(dentist);
  }

//  @Override
//  @Transactional
//  public PatientEntity loadByDentist(DentistEntity dentist) {
//    PatientEntity patientEntity = patientRepository.findByDentists(dentist);
//    if (patientEntity == null) {
//      throw new EntityNotFountException("Patient not found by dentist id : " + dentist.getId());
//    }
//    Hibernate.initialize(patientEntity.getTeeth());
//    return patientEntity;
//  }

  @Override
  public Set<PatientEntity> findByDentist(DentistEntity dentist, Pageable page) {
    return new HashSet<>(patientRepository.findByDentistsOrderByCreatedOnDesc(dentist, page));
  }

  @Override
  public Set<PatientEntity> findAllByDentist(DentistEntity dentist) {
    return new HashSet<>(patientRepository.findAllByDentists(dentist));
  }

  @Override
  @Transactional
  public Long patientsCount(Long dentistId) {
    return patientRepository.countByDentistsId(dentistId);
  }

  @Override
  public PatientEntity findByDentistIdAndPatientId(Long dentistId, Long patientId) {
    DentistEntity dentist = dentistService.get(dentistId);
    if (dentist == null) {
      throw new EntityNotFountException("Dentist not found by id : " + dentistId);
    }

    PatientEntity patient = patientRepository.findOneByDentistsAndId(dentist, patientId);
    if (patient == null) {
      throw new EntityNotFountException("Patient not found by id : " + patientId);
    }
    return patient;
  }

  @Override
  @Transactional
  public PatientEntity loadByDentistIdAndPatientId(Long dentistId, Long patientId) {
    DentistEntity dentist = dentistService.get(dentistId);
    if (dentist == null) {
      throw new EntityNotFountException("Dentist not found by id : " + dentistId);
    }

    PatientEntity patient = patientRepository.findOneByDentistsAndId(dentist, patientId);
    if (patient == null) {
      throw new EntityNotFountException("Patient not found by id : " + patientId);
    }
    Hibernate.initialize(patient.getTeeth());
    return patient;
  }

  @Override
  @Transactional
  public PatientEntity add(PatientEntity patient) {
    DentistEntity loggedInDentist = authService.getLoggedInDentist();
    DentistEntity dentist = dentistService.get(loggedInDentist.getId());
    Set<ToothEntity> teeth = patient.getTeeth();

    for (int i = 1; i <= TEETH_IN_BUCKET; i++) {
      fillTeeth(i, ToothBucket.UP_LEFT, teeth);
    }

    for (int i = 1; i <= TEETH_IN_BUCKET; i++) {
      fillTeeth(i, ToothBucket.UP_RIGHT, teeth);
    }

    for (int i = 1; i <= TEETH_IN_BUCKET; i++) {
      fillTeeth(i, ToothBucket.DOWN_LEFT, teeth);
    }

    for (int i = 1; i <= TEETH_IN_BUCKET; i++) {
      fillTeeth(i, ToothBucket.DOWN_RIGHT, teeth);
    }

    teeth.stream().forEach(t -> {
      t.setPatient(patient);
      t.setToothState(ToothState.ALIVE);
    });


    PatientEntity p = patientRepository.save(patient);
    DentistPatient dentistPatient = new DentistPatient();
    dentistPatient.setDentist(dentist);
    dentistPatient.setPatient(p);
    dentistPatientRepository.save(dentistPatient);

    return patient;
  }

  private void fillTeeth(int index, ToothBucket toothBucket, Set<ToothEntity> teeth) {
    ToothEntity tooth = new ToothEntity();
    tooth.setToothBucket(toothBucket);
    tooth.setToothNumber(index);
    teeth.add(tooth);
  }

}
