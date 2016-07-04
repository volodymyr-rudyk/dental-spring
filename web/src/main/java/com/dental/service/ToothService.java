package com.dental.service;

import com.dental.persistence.entity.Tooth;

/**
 * Created by vrudyk on 7/4/2016.
 */
public interface ToothService extends BaseService<Tooth> {

  Tooth get(Long toothId, Long patientId);

}
