package com.dental.persistence.repository;

import com.dental.persistence.entity.Tooth;

import java.util.List;

/**
 * Created by vrudyk on 7/3/2016.
 */
public interface ToothRepository extends GenericRepository<Tooth> {
  List<Tooth> getAllToothByPatientId(Long patientId);
}
