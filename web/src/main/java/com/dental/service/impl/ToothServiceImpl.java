package com.dental.service.impl;

import com.dental.persistence.entity.Tooth;
import com.dental.persistence.entity.ToothCure;
import com.dental.persistence.repository.ToothCureRepository;
import com.dental.persistence.repository.ToothRepository;
import com.dental.service.ToothService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by vrudyk on 7/4/2016.
 */
@Service
public class ToothServiceImpl implements ToothService {

  @Autowired
  private ToothRepository toothRepository;

  @Autowired
  private ToothCureRepository toothCureRepository;

  @Override
  @Transactional
  public Tooth load(Long toothId, Long patientId) {
    Tooth tooth = toothRepository.findByIdAndPatientId(toothId, patientId);
    Hibernate.initialize(tooth.getCures());
    return tooth;
  }

  @Override
  public Tooth get(Long toothId, Long patientId) {
    return toothRepository.findByIdAndPatientId(toothId, patientId);
  }

  @Override
  public ToothCure addCure(ToothCure toothCure, Long toothId, Long patientId) {
    Tooth tooth = toothRepository.findOne(toothId);
    toothCure.setCreatedOn(new Date());
    toothCure.setCure(toothCure.getCure());
    toothCure.setTooth(tooth);
    toothCureRepository.save(toothCure);
    return toothCure;
  }

  @Override
  public Tooth get(Long id) {
    return toothRepository.findOne(id);
  }
}
