package com.dental.persistence.impl;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.repository.AbstractRepository;
import com.dental.persistence.repository.DentistRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by light on 10/17/2015.
 */
@Repository
@Transactional
public class DentistRepositoryImpl extends AbstractRepository<Dentist> implements DentistRepository {
  public DentistRepositoryImpl() {
    super(Dentist.class);
  }

  @Override
  public Dentist loadFull(Long id) {
    Dentist dentist = get(id);
    Hibernate.initialize(dentist.getPatients());
    return dentist;
  }
}
