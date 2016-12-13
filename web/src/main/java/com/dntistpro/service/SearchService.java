package com.dntistpro.service;

import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.PatientEntity;

import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
public interface SearchService {
  List<PatientEntity> findByOneName(DentistEntity dentist, String oneName);

  List<PatientEntity> findByFirstName(DentistEntity dentist, String firstName);

  List<PatientEntity> findByMiddleName(DentistEntity dentist, String middleName);

  List<PatientEntity> findByLastName(DentistEntity dentist, String lastName);

  List<PatientEntity> findByFirstNameOrLastName(DentistEntity dentist, String firstName, String lastName);

  List<PatientEntity> doSearch(String q);
}
