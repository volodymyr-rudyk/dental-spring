package com.dental.service.impl;

import com.dental.bean.DentistBean;
import com.dental.exception.RequiredAuthenticationException;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.User;
import com.dental.persistence.repository.DentistRepository;
import com.dental.provider.DentalUserDetails;
import com.dental.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by light on 27.05.2015.
 */
@Service
public class DentistServiceImpl implements DentistService {

  @Autowired
  private DentistRepository dentistRepository;

  @Override
  public Dentist get(Long id) {
    return dentistRepository.get(id);
  }

  @Override
  public void save(DentistBean dentistBean) {
    Dentist dentist = transform(dentistBean);
    dentistRepository.save(dentist);
  }

  @Override
  public void update(DentistBean dentistBean, Dentist profile) {
    profile.setFirstName(dentistBean.getFirstName());
    profile.setMiddleName(dentistBean.getMiddleName());
    profile.setLastName(dentistBean.getLastName());
    profile.setBirthday(dentistBean.getBirthday());
    profile.setPhone(dentistBean.getPhone());
    dentistRepository.update(profile);
  }

  @Override
  public Dentist getLoggedInDentist() {
    DentalUserDetails dentalUserDetails = this.loadUserDetails();
    return dentalUserDetails.getUser().getDentist();
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

  private Dentist transform(DentistBean dentistBean) {
    return new Dentist();
  }
}