package com.dental.service;

import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.PatientEntity;
import com.dental.web.dto.PatientDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

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

//  @Query(nativeQuery = true, value = "SELECT * from dentist_patient dp RIGHT JOIN patient p on dp.patient_id = p.id where dp.dentist_id=?1")
//  @Query(nativeQuery = true,
//    value = "SELECT p.* from patient p LEFT JOIN dentist_patient dp on p.id = dp.patient_id where dp.dentist_id=?1")
//  Set<PatientEntity> searchPatientsByDentist(Long dentistId);
}
