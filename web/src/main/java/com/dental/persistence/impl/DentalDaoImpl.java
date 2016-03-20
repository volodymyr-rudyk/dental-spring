package com.dental.persistence.impl;

import com.dental.persistence.component.AbstractDao;
import com.dental.persistence.component.DentistDao;
import com.dental.persistence.entity.Dentist;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by light on 10/17/2015.
 */
@Repository
@Transactional
public class DentalDaoImpl extends AbstractDao<Dentist> implements DentistDao {
  public DentalDaoImpl() {
    super(Dentist.class);
  }
}
