package com.dental.service;

import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.ToothEntity;
import com.dental.persistence.entity.ToothCureEntity;
import com.dental.persistence.helperbean.ToothState;

/**
 * Created by vrudyk on 7/4/2016.
 */
public interface ToothService extends BaseService<ToothEntity> {

  ToothEntity load(Long toothId, Long patientId);

  ToothEntity get(Long toothId, Long patientId);

  ToothCureEntity addCure(DentistEntity dentist, Long patientId, Long toothId, ToothCureEntity toothCure);

  void updateCure(Long toothId, Long cureId, String cure);

  Long countCuresByDentistId(Long dentistId);

  boolean updateToothState(Long toothId, ToothState toothState);
}
