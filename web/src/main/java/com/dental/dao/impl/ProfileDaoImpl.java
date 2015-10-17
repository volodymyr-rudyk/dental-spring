package com.dental.dao.impl;

import com.dental.dao.component.AbstractDao;
import com.dental.dao.component.ProfileDao;
import com.dental.dao.entity.Profile;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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
