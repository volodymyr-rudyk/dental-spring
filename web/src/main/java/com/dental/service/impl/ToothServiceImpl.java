package com.dental.service.impl;

import com.dental.persistence.entity.Tooth;
import com.dental.persistence.repository.ToothRepository;
import com.dental.service.ToothService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vrudyk on 7/4/2016.
 */
@Service
public class ToothServiceImpl implements ToothService {

  @Autowired
  private ToothRepository toothRepository;

  @Override
  @Transactional
  public Tooth load(Long toothId, Long patientId) {
    Tooth tooth = toothRepository.findByIdAndPatientId(toothId, patientId);
    Hibernate.initialize(tooth.getCures());
    return tooth;
  }

  @Override
  public Tooth get(Long id) {
    return toothRepository.findOne(id);
  }
}
