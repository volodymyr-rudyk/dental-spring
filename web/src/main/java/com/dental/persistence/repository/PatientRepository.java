package com.dental.persistence.repository;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 27.05.2015.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
  Patient findByFirstNameAndLastName(String firstName, String lastName);
  Patient findByDentists(Dentist dentist);
  List<Patient> findByDentists(Dentist dentist, Pageable page);
  List<Patient> findAllByDentists(Dentist dentist);
  Long countByDentistsId(Long id);
}
