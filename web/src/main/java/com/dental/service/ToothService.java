package com.dental.service;

import com.dental.persistence.entity.Tooth;
import com.dental.persistence.entity.ToothCure;

/**
 * Created by vrudyk on 7/4/2016.
 */
public interface ToothService extends BaseService<Tooth> {

  Tooth load(Long toothId, Long patientId);

  Tooth get(Long toothId, Long patientId);

  ToothCure addCure(ToothCure toothCure, Long toothId, Long patientId);

}
