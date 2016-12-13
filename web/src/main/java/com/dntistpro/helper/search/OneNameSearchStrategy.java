package com.dntistpro.helper.search;

import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.PatientEntity;
import com.dntistpro.service.SearchService;

import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
public class OneNameSearchStrategy implements SearchStrategy {

  private final String oneName;
  private final SearchService searchService;

  public OneNameSearchStrategy(String oneName, SearchService searchService) {
    this.oneName = wrapLikeStr(oneName);
    this.searchService = searchService;
  }

  @Override
  public List<PatientEntity> invoke(DentistEntity dentist) {
    return searchService.findByOneName(dentist, oneName);
  }
}
