package com.dental.persistence.repository;

import com.dental.persistence.entity.DentistPatient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vrudyk on 9/14/2016.
 */
public interface DentistPatientRepository extends CrudRepository<DentistPatient, Long> {
}
