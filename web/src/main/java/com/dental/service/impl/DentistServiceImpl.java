package com.dental.service.impl;

import com.dental.bean.DentistBean;
import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.repository.DentistRepository;
import com.dental.service.DentistService;
import com.dental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by light on 27.05.2015.
 */
@Service
public class DentistServiceImpl implements DentistService {

  @Autowired
  private DentistRepository dentistRepository;

  @Autowired
  private UserService userService;

  @Override
  public DentistEntity get(Long id) {
    return dentistRepository.findOne(id);
  }

  @Override
  public void save(DentistEntity dentist) {
    dentistRepository.save(dentist);
  }

  @Override
  public void update(DentistBean dentistBean, DentistEntity dentist) {
    dentist.setFirstName(dentistBean.getFirstName());
    dentist.setMiddleName(dentistBean.getMiddleName());
    dentist.setLastName(dentistBean.getLastName());
    dentist.setBirthday(dentistBean.getBirthday());
    dentist.setPhone(dentistBean.getPhone());
    dentist.setAddress(dentistBean.getAddress());
    userService.updateLanguage(dentist.getUser(), dentistBean.getLanguage());
    dentistRepository.save(dentist);
  }

  public List<DentistEntity> findAll() {
    return (List<DentistEntity>) dentistRepository.findAll();
  }

  public DentistEntity findOne(Long id) {
    return dentistRepository.findOne(id);
  }

}