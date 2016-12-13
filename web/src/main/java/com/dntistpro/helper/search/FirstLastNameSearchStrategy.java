package com.dntistpro.helper.search;

import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.PatientEntity;
import com.dntistpro.service.SearchService;

import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
public class FirstLastNameSearchStrategy implements SearchStrategy {

  private final String firstName;
  private final SearchService searchService;
  private final String lastName;

  public FirstLastNameSearchStrategy(String firstName, String lastName, SearchService searchService) {
    this.firstName = wrapLikeStr(firstName);
    this.lastName = wrapLikeStr(lastName);
    this.searchService = searchService;
  }

  @Override
  public List<PatientEntity> invoke(DentistEntity dentist) {
    return searchService.findByFirstNameOrLastName(dentist, firstName, lastName);
  }
}
