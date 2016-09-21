package com.dental.service;

import com.dental.bean.DentistBean;
import com.dental.persistence.entity.Dentist;

import java.util.List;

/**
 * Created by vrudyk on 27.05.2015.
 */
public interface DentistService extends BaseService<Dentist>{

  void update(DentistBean dentistBean, Dentist dentist);

  void save(Dentist dentist);

  List<Dentist> findAll();

  Dentist findOne(Long id);

}
