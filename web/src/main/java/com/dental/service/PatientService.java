package com.dental.service;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;

import java.util.Collection;

/**
 * Created by vrudyk on 3/21/2016.
 */
public interface PatientService extends BaseService<Patient> {
  Patient get(String firstName, String lastName);
  Collection<Patient> getList(Dentist dentist);
}
