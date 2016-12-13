package com.dntistpro.persistence.repository;

import com.dntistpro.persistence.entity.DentistPatient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vrudyk on 9/14/2016.
 */
public interface DentistPatientRepository extends CrudRepository<DentistPatient, Long> {
}
