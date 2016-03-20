package com.dental.service;

import com.dental.bean.DentistBean;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.User;

/**
 * Created by admin on 27.05.2015.
 */
public interface DentistService {
  Dentist getDentist(int id);

  void save(DentistBean dentistBean);

  void update(DentistBean dentistBean, Dentist dentist);

  Dentist getLoggedInDentist();

  User getLoggedUser();

}
