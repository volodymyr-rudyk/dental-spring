package com.dental.service;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.web.dto.PatientDTO;
import org.springframework.data.domain.Pageable;

import java.util.Set;

/**
 * Created by vrudyk on 3/21/2016.
 */
public interface PatientService extends BaseService<Patient> {

  Patient findByFirstNameAndLastName(String firstName, String lastName);

  Patient load(Long patientId);

  boolean update(PatientDTO patientDTO, Dentist loggedInDentist);

  void add(PatientDTO patientDTO, Dentist dentist);

  Patient add(Patient patient);

  Patient findByDentist(Dentist dentist);

  Set<Patient> findByDentist(Dentist dentist, Pageable page);

  Set<Patient> findAllByDentist(Dentist dentist);

  Long patientsCount(Long dentistId);
}
