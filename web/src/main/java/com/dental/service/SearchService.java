package com.dental.service;

import com.dental.persistence.entity.PatientEntity;

import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
public interface SearchService {
  List<PatientEntity> findByOneName(String oneName);

  List<PatientEntity> findByFirstName(String firstName);

  List<PatientEntity> findByMiddleName(String middleName);

  List<PatientEntity> findByLastName(String lastName);

  List<PatientEntity> findByFirstNameOrLastName(String firstName, String lastName);

  List<PatientEntity> findByFirstNameAndLastName(String firstName, String lastName);

}
