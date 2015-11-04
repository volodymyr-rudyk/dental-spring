package com.dental.service;

import com.dental.bean.UserProfileBean;
import com.dental.persistence.entity.Profile;

import java.io.Serializable;

/**
 * Created by admin on 27.05.2015.
 */
public interface ProfileService {
  Profile getProfile(Serializable id);

  void save(UserProfileBean profileBean);

  Profile getLoggedInProfile();
}
