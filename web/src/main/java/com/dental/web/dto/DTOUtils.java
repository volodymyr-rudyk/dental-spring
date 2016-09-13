package com.dental.web.dto;

import com.dental.persistence.entity.*;
import com.dental.persistence.helperbean.Gender;
import com.dental.persistence.helperbean.ToothBucket;
import com.dental.provider.DentalUserDetails;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by light on 5/6/2016.
 */
public class DTOUtils {

  static Function<ToothCure, ToothCureDTO> convertToothCureToToothCureDto = (tc) -> {
    ToothCureDTO toothCureDTO = new ToothCureDTO();
    toothCureDTO.setId(tc.getId());
    toothCureDTO.setCreatedOn(tc.getCreatedOn());
    toothCureDTO.setCure(tc.getCure());
    return toothCureDTO;
  };

  static Function<Tooth, ToothDTO> convertToothToToothDto = (t) -> {
    ToothDTO toothDTO = new ToothDTO();
    toothDTO.setId(t.getId());
    toothDTO.setToothState(t.getToothState());
    toothDTO.setToothBucket(t.getToothBucket());
    toothDTO.setToothNumber(t.getToothNumber());
    return toothDTO;
  };

  static Function<Tooth, ToothDTO> convertDeepToothToToothDto = (t) -> {
    ToothDTO toothDTO = new ToothDTO();
    toothDTO.setId(t.getId());
    toothDTO.setToothState(t.getToothState());
    toothDTO.setToothBucket(t.getToothBucket());
    toothDTO.setToothNumber(t.getToothNumber());
    Set<ToothCureDTO> toothCureDTOSet = t.getCures().stream().map(convertToothCureToToothCureDto).collect(Collectors.toSet());
    toothDTO.setCures(toothCureDTOSet);
    return toothDTO;
  };

  private static Function<Dentist, DentistDTO> dentistToDentistDTO = dentist -> {
    DentistDTO dentistDTO = new DentistDTO();
    dentistDTO.setFirstName(dentist.getFirstName());
    dentistDTO.setLastName(dentist.getLastName());
    dentistDTO.setAddress(dentist.getAddress());
    dentistDTO.setBirthday(dentist.getBirthday());
    dentistDTO.setMiddleName(dentist.getMiddleName());
    dentistDTO.setPhone(dentist.getPhone());
    return dentistDTO;
  };
  private static Function<Patient, PatientDTO> patientToPatientDTO = patient -> {
    PatientDTO patientDTO = new PatientDTO();
    patientDTO.setId(patient.getId());
    patientDTO.setFirstName(patient.getFirstName());
    patientDTO.setLastName(patient.getLastName());
    patientDTO.setMiddleName(patient.getMiddleName());
    patientDTO.setAddress(patient.getAddress());
    patientDTO.setGender(patient.getGender().name());
    patientDTO.setBirthday(patient.getBirthday());
    patientDTO.setPhone(patient.getPhone());
    return patientDTO;
  };
  private static Function<PatientDTO, Patient> patientDTOPToPatient = patientDTO -> {
    Patient patient = new Patient();
    patient.setFirstName(patientDTO.getFirstName());
    patient.setLastName(patientDTO.getLastName());
    patient.setAddress(patientDTO.getAddress());
    patient.setMiddleName(patientDTO.getMiddleName());
    patient.setBirthday(patientDTO.getBirthday());
    patient.setGender(Gender.get(patientDTO.getGender()));
    patient.setPhone(patientDTO.getPhone());
    return patient;
  };
  private static Function<DentalUserDetails, SigninDTO> userDetailsToSigninDTO = userDetails -> {
    SigninDTO signinDTO = new SigninDTO();
    User user = userDetails.getUser();

    signinDTO.setUserEmail(user.getEmail());
    signinDTO.setCreatedOn(user.getCreatedOn());

    Dentist dentist = user.getDentist();
    signinDTO.setFirstName(dentist.getFirstName());
    signinDTO.setLastName(dentist.getLastName());
    signinDTO.setAddress(dentist.getAddress());
    signinDTO.setMiddleName(dentist.getMiddleName());
    signinDTO.setBirthday(dentist.getBirthday());
    signinDTO.setPhone(dentist.getPhone());

    return signinDTO;
  };

  public static DentistDTO convert(Dentist dentist) {
    return dentistToDentistDTO.apply(dentist);
  }

  public static DentistDTO convertDeep(Dentist dentist) {
    DentistDTO dentistDTO = dentistToDentistDTO.apply(dentist);
    if (dentist.getPatients().size() > 0) {
      for (Patient patient : dentist.getPatients()) {
        PatientDTO patientDTO = convert(patient);
        dentistDTO.getPatients().add(patientDTO);
      }
    }
    return dentistDTO;
  }

  public static PatientDTO convertDeep(Patient patient) {
    PatientDTO patientDTO = convert(patient);
    Set<ToothDTO> upLeftToothDTOSet = patient.getTeeth().stream().filter(t -> t.getToothBucket() == ToothBucket.UP_LEFT).map(convertToothToToothDto).collect(Collectors.toSet());
    Set<ToothDTO> upRightToothDTOSet = patient.getTeeth().stream().filter(t -> t.getToothBucket() == ToothBucket.UP_RIGHT).map(convertToothToToothDto).collect(Collectors.toSet());
    Set<ToothDTO> downLeftToothDTOSet = patient.getTeeth().stream().filter(t -> t.getToothBucket() == ToothBucket.DOWN_LEFT).map(convertToothToToothDto).collect(Collectors.toSet());
    Set<ToothDTO> downRightToothDTOSet = patient.getTeeth().stream().filter(t -> t.getToothBucket() == ToothBucket.DOWN_RIGHT).map(convertToothToToothDto).collect(Collectors.toSet());

    patientDTO.setTeethUL(upLeftToothDTOSet);
    patientDTO.setTeethUR(upRightToothDTOSet);
    patientDTO.setTeethDL(downLeftToothDTOSet);
    patientDTO.setTeethDR(downRightToothDTOSet);

    return patientDTO;
  }

  public static ToothDTO convert(Tooth tooth) {
    return convertToothToToothDto.apply(tooth);
  }

  public static ToothDTO convertDeep(Tooth tooth) {
    return convertDeepToothToToothDto.apply(tooth);
  }

  public static Patient convert(PatientDTO patientDTO) {
    return patientDTOPToPatient.apply(patientDTO);
  }

  public static PatientDTO convert(Patient patient) {
    return patientToPatientDTO.apply(patient);
  }

  public static Set<PatientDTO> convert(Set<Patient> patients) {
    return patients.stream().map(patientToPatientDTO).collect(Collectors.toSet());
  }

  public static ToothCureDTO convert(ToothCure toothCure) {
    ToothCureDTO toothCureDTO = new ToothCureDTO();
    toothCureDTO.setCure(toothCure.getCure());
    toothCureDTO.setCreatedOn(toothCure.getCreatedOn());
    toothCureDTO.setId(toothCure.getId());
    return toothCureDTO;
  }

  public static SigninDTO convert(DentalUserDetails dentalUserDetails) {
    return userDetailsToSigninDTO.apply(dentalUserDetails);
  }
}