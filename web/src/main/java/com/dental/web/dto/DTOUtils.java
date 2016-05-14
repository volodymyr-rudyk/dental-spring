package com.dental.web.dto;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.helperbean.Gender;

/**
 * Created by light on 5/6/2016.
 */
public class DTOUtils {

  public static DentistDTO convert(Dentist dentist) {
    DentistDTO dentistDTO = new DentistDTO();
    dentistDTO.setFirstName(dentist.getFirstName());
    dentistDTO.setLastName(dentist.getLastName());
    dentistDTO.setAddress(dentist.getAddress());
    dentistDTO.setBirthday(dentist.getBirthday());
    dentistDTO.setMiddleName(dentist.getMiddleName());
    dentistDTO.setPhone(dentist.getPhone());
    if (dentist.getPatients().size() > 0) {
      for (Patient patient : dentist.getPatients()) {
        PatientDTO patientDTO = convert(patient);
        dentistDTO.getPatients().add(patientDTO);
      }
    }
    return dentistDTO;
  }

  public static PatientDTO convert(Patient patient) {
    PatientDTO patientDTO = new PatientDTO();
    patientDTO.setFirstName(patient.getFirstName());
    patientDTO.setLastName(patient.getLastName());
    patientDTO.setMiddleName(patient.getMiddleName());
    patientDTO.setAddress(patient.getAddress());
    patientDTO.setGender(patient.getGender().name());
    patientDTO.setBirthday(patient.getBirthday());
    patientDTO.setPhone(patient.getPhone());
    return patientDTO;
  }

  public static Patient convert(PatientDTO patientDTO) {
    Patient patient = new Patient();
    patient.setFirstName(patientDTO.getFirstName());
    patient.setLastName(patientDTO.getLastName());
    patient.setAddress(patientDTO.getAddress());
    patient.setMiddleName(patientDTO.getMiddleName());
    patient.setBirthday(patientDTO.getBirthday());
    patient.setGender(Gender.get(patientDTO.getGender()));
    patient.setPhone(patientDTO.getPhone());
    return patient;
  }


}