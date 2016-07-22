package com.dental.service.impl;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.entity.Tooth;
import com.dental.persistence.helperbean.Gender;
import com.dental.persistence.helperbean.ToothGrid;
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
  public Patient getFull(Long patientId) {
    return patientRepository.getFull(patientId);
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
    ul1.setToothGrid(ToothGrid.UP_LEFT_1);

    Tooth ul2 = new Tooth();
    ul2.setToothGrid(ToothGrid.UP_LEFT_2);

    Tooth ul3 = new Tooth();
    ul3.setToothGrid(ToothGrid.UP_LEFT_3);

    Tooth ul4 = new Tooth();
    ul4.setToothGrid(ToothGrid.UP_LEFT_4);

    Tooth ul5 = new Tooth();
    ul5.setToothGrid(ToothGrid.UP_LEFT_5);

    Tooth ul6 = new Tooth();
    ul6.setToothGrid(ToothGrid.UP_LEFT_6);

    Tooth ul7 = new Tooth();
    ul7.setToothGrid(ToothGrid.UP_LEFT_7);

    Tooth ul8 = new Tooth();
    ul8.setToothGrid(ToothGrid.UP_LEFT_8);


    Tooth ur1 = new Tooth();
    ur1.setToothGrid(ToothGrid.UP_RIGHT_1);

    Tooth ur2 = new Tooth();
    ur2.setToothGrid(ToothGrid.UP_RIGHT_2);

    Tooth ur3 = new Tooth();
    ur3.setToothGrid(ToothGrid.UP_RIGHT_3);

    Tooth ur4 = new Tooth();
    ur4.setToothGrid(ToothGrid.UP_RIGHT_4);

    Tooth ur5 = new Tooth();
    ur5.setToothGrid(ToothGrid.UP_RIGHT_5);

    Tooth ur6 = new Tooth();
    ur6.setToothGrid(ToothGrid.UP_RIGHT_6);

    Tooth ur7 = new Tooth();
    ur7.setToothGrid(ToothGrid.UP_RIGHT_7);

    Tooth ur8 = new Tooth();
    ur8.setToothGrid(ToothGrid.UP_RIGHT_8);


    Tooth dl1 = new Tooth();
    dl1.setToothGrid(ToothGrid.DOWN_LEFT_1);

    Tooth dl2 = new Tooth();
    dl2.setToothGrid(ToothGrid.DOWN_LEFT_2);

    Tooth dl3 = new Tooth();
    dl3.setToothGrid(ToothGrid.DOWN_LEFT_3);

    Tooth dl4 = new Tooth();
    dl4.setToothGrid(ToothGrid.DOWN_LEFT_4);

    Tooth dl5 = new Tooth();
    dl5.setToothGrid(ToothGrid.DOWN_LEFT_5);

    Tooth dl6 = new Tooth();
    dl6.setToothGrid(ToothGrid.DOWN_LEFT_6);

    Tooth dl7 = new Tooth();
    dl7.setToothGrid(ToothGrid.DOWN_LEFT_7);

    Tooth dl8 = new Tooth();
    dl8.setToothGrid(ToothGrid.DOWN_LEFT_8);


    Tooth dr1 = new Tooth();
    dr1.setToothGrid(ToothGrid.DOWN_RIGHT_1);

    Tooth dr2 = new Tooth();
    dr2.setToothGrid(ToothGrid.DOWN_RIGHT_2);

    Tooth dr3 = new Tooth();
    dr3.setToothGrid(ToothGrid.DOWN_RIGHT_3);

    Tooth dr4 = new Tooth();
    dr4.setToothGrid(ToothGrid.DOWN_RIGHT_4);

    Tooth dr5 = new Tooth();
    dr5.setToothGrid(ToothGrid.DOWN_RIGHT_5);

    Tooth dr6 = new Tooth();
    dr6.setToothGrid(ToothGrid.DOWN_RIGHT_6);

    Tooth dr7 = new Tooth();
    dr7.setToothGrid(ToothGrid.DOWN_RIGHT_7);

    Tooth dr8 = new Tooth();
    dr8.setToothGrid(ToothGrid.DOWN_RIGHT_8);

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
