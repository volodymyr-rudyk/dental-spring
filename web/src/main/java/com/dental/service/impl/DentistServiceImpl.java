package com.dental.service.impl;

import com.dental.bean.DentistBean;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.repository.DentistRepository;
import com.dental.service.DentistService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by light on 27.05.2015.
 */
@Service
public class DentistServiceImpl implements DentistService {

  @Autowired
  private DentistRepository dentistRepository;

  @Override
  public Dentist get(Long id) {
    return dentistRepository.findOne(id);
  }

  @Override
  @Transactional
  public Dentist load(Long id) {
    Dentist dentist = dentistRepository.findOne(id);
    Hibernate.initialize(dentist.getPatients());
    return dentist;
  }

  @Override
  public void save(DentistBean dentistBean) {
    Dentist dentist = transform(dentistBean);
    dentistRepository.save(dentist);
  }

  @Override
  public void save(Dentist dentist) {
    dentistRepository.save(dentist);
  }

  @Override
  public void update(DentistBean dentistBean, Dentist dentist) {
    dentist.setFirstName(dentistBean.getFirstName());
    dentist.setMiddleName(dentistBean.getMiddleName());
    dentist.setLastName(dentistBean.getLastName());
    dentist.setBirthday(dentistBean.getBirthday());
    dentist.setPhone(dentistBean.getPhone());
    dentist.setAddress(dentistBean.getAddress());
    dentistRepository.save(dentist);
  }

  public List<Dentist> findAll() {
    return (List<Dentist>) dentistRepository.findAll();
  }

  public Dentist findOne(Long id) {
    return dentistRepository.findOne(id);
  }

  private Dentist transform(DentistBean dentistBean) {
    return new Dentist();
  }
}