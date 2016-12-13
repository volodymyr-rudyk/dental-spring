package com.dntistpro.service.impl;

import com.dntistpro.exception.EntityNotFountException;
import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.ToothEntity;
import com.dntistpro.persistence.entity.ToothCureEntity;
import com.dntistpro.persistence.helper.ToothState;
import com.dntistpro.persistence.repository.ToothCureRepository;
import com.dntistpro.persistence.repository.ToothRepository;
import com.dntistpro.service.ToothService;
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
  public ToothEntity load(Long toothId, Long patientId) {
    ToothEntity tooth = toothRepository.findByIdAndPatientId(toothId, patientId);
    Hibernate.initialize(tooth.getCures());
    return tooth;
  }

  @Override
  public ToothEntity get(Long toothId, Long patientId) {
    return toothRepository.findByIdAndPatientId(toothId, patientId);
  }

  @Override
  public ToothCureEntity addCure(DentistEntity dentist, Long patientId, Long toothId, ToothCureEntity toothCure) {
    ToothEntity tooth = toothRepository.findOne(toothId);
    toothCure.setCreatedOn(new Date());
    toothCure.setCure(toothCure.getCure());
    toothCure.setTooth(tooth);
    toothCure.setDentist(dentist);
    toothCureRepository.save(toothCure);
    return toothCure;
  }

  @Override
  public void updateCure(Long toothId, Long cureId, String cure) {
    ToothCureEntity toothCure = toothCureRepository.findByIdAndToothId(cureId, toothId);
    toothCure.setCure(cure);
    toothCureRepository.save(toothCure);
  }

  @Override
  public Long countCuresByDentistId(Long dentistId) {
    return toothCureRepository.countByDentistId(dentistId);
  }

  @Override
  public boolean updateToothState(Long toothId, ToothState toothState) {
    ToothEntity tooth = toothRepository.findOne(toothId);
    if (tooth == null) {
      throw new EntityNotFountException("Tooth not found " + toothId);
    }
    tooth.setToothState(toothState);
    toothRepository.save(tooth);
    return true;
  }

  @Override
  public ToothEntity get(Long id) {
    return toothRepository.findOne(id);
  }
}
