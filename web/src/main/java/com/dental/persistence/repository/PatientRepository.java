package com.dental.persistence.repository;

import com.dental.persistence.entity.Patient;

import java.util.Collection;

/**
 * Created by admin on 27.05.2015.
 */
public interface PatientRepository extends GenericRepository<Patient> {
  Patient findByFirstAndLastName(String firstName, String lastName);
  Collection<Patient> getPatientsByDentist(Long dentistId);
}
