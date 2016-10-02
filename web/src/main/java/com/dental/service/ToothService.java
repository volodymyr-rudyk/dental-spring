package com.dental.service;

import com.dental.persistence.entity.ToothEntity;
import com.dental.persistence.entity.ToothCureEntity;
import com.dental.persistence.helperbean.ToothState;

/**
 * Created by vrudyk on 7/4/2016.
 */
public interface ToothService extends BaseService<ToothEntity> {

  ToothEntity load(Long toothId, Long patientId);

  ToothEntity get(Long toothId, Long patientId);

  ToothCureEntity addCure(ToothCureEntity toothCure, Long toothId, Long patientId);

  Long countCuresByDentistId(Long dentistId);

  boolean updateToothState(Long toothId, ToothState toothState);
}
