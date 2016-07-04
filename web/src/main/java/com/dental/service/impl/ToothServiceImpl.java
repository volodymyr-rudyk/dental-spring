package com.dental.service.impl;

import com.dental.persistence.entity.Tooth;
import com.dental.persistence.repository.ToothRepository;
import com.dental.service.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vrudyk on 7/4/2016.
 */
@Service
public class ToothServiceImpl implements ToothService {

  @Autowired
  private ToothRepository toothRepository;

  @Override
  public Tooth get(Long toothId, Long patientId) {
    return toothRepository.get(toothId, patientId);
  }

  @Override
  public Tooth get(Long id) {
    return toothRepository.get(id);
  }
}
