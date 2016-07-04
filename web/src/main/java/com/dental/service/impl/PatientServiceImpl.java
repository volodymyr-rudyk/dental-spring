package com.dental.service.impl;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.entity.Tooth;
import com.dental.persistence.helperbean.Gender;
import com.dental.persistence.helperbean.ToothState;
import com.dental.persistence.repository.PatientRepository;
import com.dental.service.AuthService;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.PatientDTO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Created by vrudyk on 3/22/2016.
 */
@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  private AuthService authService;

  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private DentistService dentistService;

  @Override
  public Patient get(String firstName, String lastName) {
    return patientRepository.findByFirstAndLastName(firstName, lastName);
  }

  @Override
  public Collection<Patient> getList(Dentist dentistBean) {
    if (dentistBean == null) return Collections.emptyList();
    Collection<Patient> patients = patientRepository.getPatientsByDentist(dentistBean.getId());
    return patients;
  }

  @Override
  public Patient get(Long id) {
    return patientRepository.get(id);
  }

  @Override
  @Transactional
  public boolean update(PatientDTO patientDTO, Dentist loggedInDentist) {
    Collection<Patient> patients = patientRepository.getPatientsByDentist(loggedInDentist.getId());
    Optional<Patient> optional = patients.stream().filter((p) -> p.getId().equals(patientDTO.getId())).findFirst();
    optional.ifPresent(p -> {
      p.setFirstName(patientDTO.getFirstName());
      p.setLastName(patientDTO.getLastName());
      p.setMiddleName(patientDTO.getMiddleName());
      p.setMiddleName(patientDTO.getMiddleName());
      p.setAddress(patientDTO.getAddress());
      p.setBirthday(patientDTO.getBirthday());
      p.setGender(Gender.get(patientDTO.getGender()));
      p.setPhone(patientDTO.getPhone());
      patientRepository.update(p);
    });
    return true;
  }

  @Override
  public void add(PatientDTO patientDTO, Dentist dentist) {
    Patient patient = DTOUtils.convert(patientDTO);
    patient.getDentists().add(dentist);
    patientRepository.save(patient);
  }

  @Override
  @Transactional
  public void add(Patient patient) {
    Dentist loggedInDentist = authService.getLoggedInDentist();
    Dentist dentist = dentistService.get(loggedInDentist.getId());
    Hibernate.initialize(dentist.getPatients());
    dentist.getPatients().add(patient);

    Set<Tooth> teeth = patient.getTeeth();
    Tooth ul1 = new Tooth();
    Tooth ul2 = new Tooth();
    Tooth ul3 = new Tooth();
    Tooth ul4 = new Tooth();
    Tooth ul5 = new Tooth();
    Tooth ul6 = new Tooth();
    Tooth ul7 = new Tooth();
    Tooth ul8 = new Tooth();

    Tooth ur1 = new Tooth();
    Tooth ur2 = new Tooth();
    Tooth ur3 = new Tooth();
    Tooth ur4 = new Tooth();
    Tooth ur5 = new Tooth();
    Tooth ur6 = new Tooth();
    Tooth ur7 = new Tooth();
    Tooth ur8 = new Tooth();

    Tooth dl1 = new Tooth();
    Tooth dl2 = new Tooth();
    Tooth dl3 = new Tooth();
    Tooth dl4 = new Tooth();
    Tooth dl5 = new Tooth();
    Tooth dl6 = new Tooth();
    Tooth dl7 = new Tooth();
    Tooth dl8 = new Tooth();

    Tooth dr1 = new Tooth();
    Tooth dr2 = new Tooth();
    Tooth dr3 = new Tooth();
    Tooth dr4 = new Tooth();
    Tooth dr5 = new Tooth();
    Tooth dr6 = new Tooth();
    Tooth dr7 = new Tooth();
    Tooth dr8 = new Tooth();

    teeth.add(ul1);
    teeth.add(ul2);
    teeth.add(ul3);
    teeth.add(ul4);
    teeth.add(ul5);
    teeth.add(ul6);
    teeth.add(ul7);
    teeth.add(ul8);

    teeth.add(ur1);
    teeth.add(ur2);
    teeth.add(ur3);
    teeth.add(ur4);
    teeth.add(ur5);
    teeth.add(ur6);
    teeth.add(ur7);
    teeth.add(ur8);

    teeth.add(dl1);
    teeth.add(dl2);
    teeth.add(dl3);
    teeth.add(dl4);
    teeth.add(dl5);
    teeth.add(dl6);
    teeth.add(dl7);
    teeth.add(dl8);

    teeth.add(dr1);
    teeth.add(dr2);
    teeth.add(dr3);
    teeth.add(dr4);
    teeth.add(dr5);
    teeth.add(dr6);
    teeth.add(dr7);
    teeth.add(dr8);

    teeth.stream().forEach(t -> {
      t.setPatient(patient);
      t.setToothState(ToothState.UNDEFINED);
    });

    dentistService.save(dentist);
  }

  @Override
  public Patient findIn(Long patientId, Set<Patient> patients) {
    Optional<Patient> patient = patients.stream().filter(p -> p.getId().equals(patientId)).findFirst();
    return patient.get();
  }
}
