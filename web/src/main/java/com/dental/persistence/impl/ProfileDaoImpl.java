package com.dental.persistence.impl;

import com.dental.persistence.component.AbstractDao;
import com.dental.persistence.component.ProfileDao;
import com.dental.persistence.entity.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by light on 10/17/2015.
 */
@Repository
@Transactional
public class ProfileDaoImpl extends AbstractDao<Profile> implements ProfileDao {
  public ProfileDaoImpl() {
    super(Profile.class);
  }
}
