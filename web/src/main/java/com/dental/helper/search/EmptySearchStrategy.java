package com.dental.helper.search;

import com.dental.persistence.entity.PatientEntity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
public class EmptySearchStrategy implements SearchStrategy {
  @Override
  public List<PatientEntity> invoke() {
    return new LinkedList<>();
  }
}
