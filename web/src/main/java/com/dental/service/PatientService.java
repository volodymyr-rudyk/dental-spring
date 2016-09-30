package com.dental.service;

import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.PatientEntity;
import com.dental.web.dto.PatientDTO;
import org.springframework.data.domain.Pageable;

import java.util.Set;

/**
 * Created by vrudyk on 3/21/2016.
 */
public interface PatientService extends BaseService<PatientEntity> {

  PatientEntity findByFirstNameAndLastName(String firstName, String lastName);

  PatientEntity load(Long patientId);

  boolean update(PatientDTO patientDTO, DentistEntity loggedInDentist);

  void add(PatientDTO patientDTO, DentistEntity dentist);

  PatientEntity add(PatientEntity patient);

  PatientEntity findByDentist(DentistEntity dentist);

  Set<PatientEntity> findByDentist(DentistEntity dentist, Pageable page);

  Set<PatientEntity> findAllByDentist(DentistEntity dentist);

  Long patientsCount(Long dentistId);
}
