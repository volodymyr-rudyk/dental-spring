package com.dental.service.impl;

import com.dental.bean.UserProfileBean;
import com.dental.exception.RequiredAuthenticationException;
import com.dental.persistence.component.ProfileDao;
import com.dental.persistence.entity.Profile;
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
  public void save(UserProfileBean profileBean) {
    Profile profile = transform(profileBean);
    profileDao.save(profile);
  }

  @Override
  public Profile getLoggedInProfile() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null) throw new RequiredAuthenticationException("getLoggedInProfile");
    DentalUserDetails dentalUserDetails = (DentalUserDetails) authentication.getPrincipal();
    return dentalUserDetails.getUser().getProfile();
  }

  private Profile transform(UserProfileBean profileBean) {
    // TODO add transformer
    return new Profile();
  }
}
