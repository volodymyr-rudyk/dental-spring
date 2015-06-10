package com.dental.service.impl;

import com.dental.bean.UserProfileBean;
import com.dental.dao.component.ProfileDao;
import com.dental.dao.entity.Profile;
import com.dental.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by light on 27.05.2015.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired
  private ProfileDao profileDao;

  @Override
  public Profile getProfile(Serializable id) {
    return profileDao.get(id);
  }

  @Override
  public void save(UserProfileBean profileBean) {
    Profile profile = transform(profileBean);
    profileDao.save(profile);
  }

  private Profile transform(UserProfileBean profileBean) {
    return new Profile();
  }
}
