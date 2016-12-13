package com.dntistpro.helper.search;

import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.PatientEntity;

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
