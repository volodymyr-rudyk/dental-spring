package com.dental.persistence.repository;

import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.PatientEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
@org.springframework.stereotype.Repository
public interface SearchRepository extends Repository<PatientEntity, Long> {
  List<PatientEntity> findByFirstNameLike(String firstName);

  List<PatientEntity> findByMiddleNameLike(String middleName);

  List<PatientEntity> findByLastNameLike(String lastName);

  List<PatientEntity> findByFirstNameLikeOrLastNameLike(String lastName, String firstName);

  List<PatientEntity> findByFirstNameLikeOrLastNameLikeOrLastNameLikeOrFirstNameLike(String firstName, String lastName, String lName, String fName);
}
