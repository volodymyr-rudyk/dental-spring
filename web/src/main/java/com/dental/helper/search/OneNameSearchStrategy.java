package com.dental.helper.search;

import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.PatientEntity;
import com.dental.service.SearchService;

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
    return searchService.findByFirstName(dentist, oneName);
  }
}
