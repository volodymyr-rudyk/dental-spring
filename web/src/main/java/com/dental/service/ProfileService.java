package com.dental.service;

import com.dental.bean.ProfileBean;
import com.dental.persistence.entity.Profile;
import com.dental.persistence.entity.User;

/**
 * Created by admin on 27.05.2015.
 */
public interface ProfileService {
  Profile getProfile(int id);

  void save(ProfileBean profileBean);

  void update(ProfileBean profileBean, Profile profile);

  Profile getLoggedInProfile();

  User getLoggedUser();

}
