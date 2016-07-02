package com.dental.service;

import com.dental.bean.DentistBean;
import com.dental.persistence.entity.Dentist;

/**
 * Created by admin on 27.05.2015.
 */
public interface DentistService extends BaseService<Dentist>{

  Dentist getFull(Long id);

  void save(DentistBean dentistBean);

  void update(DentistBean dentistBean, Dentist dentist);

  void save(Dentist dentist);

}
