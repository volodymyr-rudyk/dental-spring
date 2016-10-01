package com.dental.helper.search;

import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.PatientEntity;

import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
public interface SearchStrategy {
  List<PatientEntity> invoke(DentistEntity dentist);

  default String wrapLikeStr(String str) {
    return "%" + str + "%";
  }
}
