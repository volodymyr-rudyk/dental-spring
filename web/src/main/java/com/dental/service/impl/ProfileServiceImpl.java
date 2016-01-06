package com.dental.service.impl;

import com.dental.bean.ProfileBean;
import com.dental.exception.RequiredAuthenticationException;
import com.dental.persistence.component.ProfileDao;
import com.dental.persistence.entity.Profile;
import com.dental.persistence.entity.User;
import com.dental.provider.DentalUserDetails;
import com.dental.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by light on 27.05.2015.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired
  private ProfileDao profileDao;

  @Override
  public Profile getProfile(int id) {
    return profileDao.get(id);
  }

  @Override
  public void save(ProfileBean profileBean) {
    Profile profile = transform(profileBean);
    profileDao.save(profile);
  }

  @Override
  public void update(ProfileBean profileBean, Profile profile) {
    profile.setFirstName(profileBean.getFirstName());
    profile.setMiddleName(profileBean.getMiddleName());
    profile.setLastName(profileBean.getLastName());
    profile.setBirthday(profileBean.getBirthday());
    profile.setPhone(profileBean.getPhone());
    profileDao.update(profile);
  }

  @Override
  public Profile getLoggedInProfile() {
    DentalUserDetails dentalUserDetails = this.loadUserDetails();
    return dentalUserDetails.getUser().getProfile();
  }

  @Override
  public User getLoggedUser() {
    DentalUserDetails dentalUserDetails = this.loadUserDetails();
    return dentalUserDetails.getUser();
  }

  private DentalUserDetails loadUserDetails() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null) throw new RequiredAuthenticationException("getLoggedInProfile");
    return (DentalUserDetails) authentication.getPrincipal();
  }

  private Profile transform(ProfileBean profileBean) {

    return new Profile();
  }
}
