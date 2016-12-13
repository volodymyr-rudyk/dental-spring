package com.dntistpro.persistence.repository;

import com.dntistpro.persistence.entity.PatientEntity;
import com.dntistpro.persistence.entity.ToothEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vrudyk on 7/3/2016.
 */

@Repository
public interface ToothRepository extends CrudRepository<ToothEntity, Long> {

  List<ToothEntity> findAllByPatient(PatientEntity patient);

  ToothEntity findByIdAndPatientId(Long toothId, Long patientId);

}