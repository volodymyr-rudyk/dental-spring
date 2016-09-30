package com.dental.service.impl;

import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.PatientEntity;
import com.dental.persistence.repository.SearchRepository;
import com.dental.service.SearchService;
import org.aspectj.apache.bcel.Repository;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
@Service
public class SearchServiceImpl implements SearchService {

  @Autowired
  private SearchRepository searchRepository;

  @Override
  public List<PatientEntity> findByOneName(String oneName) {
    return searchRepository.findByFirstNameLikeOrLastNameLike(oneName, oneName);
  }

  @Override
  public List<PatientEntity> findByFirstName(String firstName) {
    return searchRepository.findByFirstNameLike(firstName);
  }

  @Override
  public List<PatientEntity> findByMiddleName(String middleName) {
    return searchRepository.findByMiddleNameLike(middleName);
  }

  @Override
  public List<PatientEntity> findByLastName(String lastName) {
    return searchRepository.findByLastNameLike(lastName);
  }

  @Override
  public List<PatientEntity> findByFirstNameOrLastName(String firstName, String lastName) {
    return searchRepository.findByFirstNameLikeOrLastNameLike(firstName, lastName);
  }

  @Override
  public List<PatientEntity> findByFirstNameAndLastName(String firstName, String lastName) {
    return searchRepository.findByFirstNameLikeOrLastNameLikeOrLastNameLikeOrFirstNameLike(firstName, firstName, lastName, lastName);
  }
}
