package com.dental.persistence.repository;

import com.dental.persistence.entity.Patient;
import com.dental.persistence.entity.Tooth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vrudyk on 7/3/2016.
 */

@Repository
public interface ToothRepository extends CrudRepository<Tooth, Long> {
  List<Tooth> findAllByPatient(Patient patient);
//  Tooth findByIdAndPatient(Long toothId, Patient patient);

  Tooth findByIdAndPatientId(Long toothId, Long patientId);
}
