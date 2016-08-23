package com.dental.persistence.repository;

import com.dental.persistence.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 27.05.2015.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
  Patient findByFirstNameAndLastName(String firstName, String lastName);
}
