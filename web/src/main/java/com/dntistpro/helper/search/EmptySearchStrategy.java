package com.dntistpro.helper.search;

import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.PatientEntity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
public class EmptySearchStrategy implements SearchStrategy {
  @Override
  public List<PatientEntity> invoke(DentistEntity dentist) {
    return new LinkedList<>();
  }
}
