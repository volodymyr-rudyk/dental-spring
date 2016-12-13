package com.dntistpro.web.dto;

import com.dntistpro.persistence.entity.*;
import com.dntistpro.persistence.helper.Gender;
import com.dntistpro.persistence.helper.ToothBucket;
import com.dntistpro.provider.DentalUserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by light on 5/6/2016.
 */
public class DTOUtils {

  private DTOUtils() {}

  private static Function<ToothCureEntity, ToothCureDTO> convertToothCureToToothCureDto = tc -> {
    ToothCureDTO toothCureDTO = new ToothCureDTO();
    toothCureDTO.setId(tc.getId());
    toothCureDTO.setCreatedOn(tc.getCreatedOn());
    toothCureDTO.setCure(tc.getCure());
    return toothCureDTO;
  };
  private static Function<ToothEntity, ToothDTO> convertToothToToothDto = t -> {
    ToothDTO toothDTO = new ToothDTO();
    toothDTO.setId(t.getId());
    toothDTO.setToothState(t.getToothState().getState());
    toothDTO.setToothBucket(t.getToothBucket().getBucketName());
    toothDTO.setToothNumber(t.getToothNumber());
    return toothDTO;
  };
  private static Function<ToothEntity, ToothDTO> convertDeepToothToToothDto = t -> {
    ToothDTO toothDTO = new ToothDTO();
    toothDTO.setId(t.getId());
    toothDTO.setToothState(t.getToothState().getState());
    toothDTO.setToothBucket(t.getToothBucket().getBucketName());
    toothDTO.setToothNumber(t.getToothNumber());
    Set<ToothCureDTO> toothCureDTOSet = t.getCures().stream().map(convertToothCureToToothCureDto).collect(Collectors.toSet());
    toothDTO.setCures(toothCureDTOSet);
    return toothDTO;
  };
  private static Function<DentistEntity, DentistDTO> dentistToDentistDTO = dentist -> {
    DentistDTO dentistDTO = new DentistDTO();
    dentistDTO.setFirstName(dentist.getFirstName());
    dentistDTO.setLastName(dentist.getLastName());
    dentistDTO.setAddress(dentist.getAddress());
    dentistDTO.setBirthday(dentist.getBirthday());
    dentistDTO.setMiddleName(dentist.getMiddleName());
    dentistDTO.setPhone(dentist.getPhone());
    dentistDTO.setCreatedOn(dentist.getCreatedOn());
    return dentistDTO;
  };
  private static Function<DentistEntity, DentistDTO> dentistToDentistDTOShort = dentist -> {
    DentistDTO dentistDTO = new DentistDTO();
    dentistDTO.setFirstName(dentist.getFirstName());
    dentistDTO.setLastName(dentist.getLastName());
    dentistDTO.setAddress(dentist.getAddress());
    return dentistDTO;
  };
  private static Function<DentistEntity, ProfileDTO> dentistToProfileDTO = dentist -> {
    ProfileDTO profileDTO = new ProfileDTO();
    profileDTO.setFirstName(dentist.getFirstName());
    profileDTO.setLastName(dentist.getLastName());
    profileDTO.setAddress(dentist.getAddress());
    profileDTO.setBirthday(dentist.getBirthday());
    profileDTO.setMiddleName(dentist.getMiddleName());
    profileDTO.setPhone(dentist.getPhone());
    UserEntity user = dentist.getUser();
    profileDTO.setCreatedOn(user.getCreatedOn());
    profileDTO.setEmail(user.getEmail());
    profileDTO.setLanguage(user.getLanguage().getCode());
    return profileDTO;
  };
  private static Function<PatientEntity, PatientDTO> patientToPatientDTO = patient -> {
    PatientDTO patientDTO = new PatientDTO();
    patientDTO.setId(patient.getId());
    patientDTO.setFirstName(patient.getFirstName());
    patientDTO.setLastName(patient.getLastName());
    patientDTO.setMiddleName(patient.getMiddleName());
    patientDTO.setAddress(patient.getAddress());
    patientDTO.setGender(patient.getGender().name());
    patientDTO.setBirthday(patient.getBirthday());
    patientDTO.setPhone(patient.getPhone());
    patientDTO.setCreatedOn(patient.getCreatedOn());
    return patientDTO;
  };
  private static Function<PatientEntity, SearchPatientDTO> patientToSearchPatientDTO = patient -> {
    SearchPatientDTO searchPatientDTO = new SearchPatientDTO();
    searchPatientDTO.setId(patient.getId());
    searchPatientDTO.setFirstName(patient.getFirstName());
    searchPatientDTO.setLastName(patient.getLastName());
    searchPatientDTO.setMiddleName(patient.getMiddleName());
    searchPatientDTO.setAddress(patient.getAddress());
    searchPatientDTO.setGender(patient.getGender().name());
    searchPatientDTO.setBirthday(patient.getBirthday());
    searchPatientDTO.setPhone(patient.getPhone());
    searchPatientDTO.setCreatedOn(patient.getCreatedOn());
    return searchPatientDTO;
  };
  private static Function<PatientDTO, PatientEntity> patientDTOToPatient = patientDTO -> {
    PatientEntity patient = new PatientEntity();
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
    UserEntity user = userDetails.getUser();

    signinDTO.setUserEmail(user.getEmail());
    signinDTO.setCreatedOn(user.getCreatedOn());
    signinDTO.setLanguage(user.getLanguage().getCode());

    DentistEntity dentist = user.getDentist();
    signinDTO.setFirstName(dentist.getFirstName());
    signinDTO.setLastName(dentist.getLastName());
    signinDTO.setAddress(dentist.getAddress());
    signinDTO.setMiddleName(dentist.getMiddleName());
    signinDTO.setBirthday(dentist.getBirthday());
    signinDTO.setPhone(dentist.getPhone());

    return signinDTO;
  };

  public static DentistDTO convert(DentistEntity dentist) {
    return dentistToDentistDTO.apply(dentist);
  }
  public static DentistDTO convertShort(DentistEntity dentist) {
    return dentistToDentistDTOShort.apply(dentist);
  }

  public static ProfileDTO convertToProfile(DentistEntity dentist) {
    return dentistToProfileDTO.apply(dentist);
  }

  public static DentistDTO convertDeep(DentistEntity dentist) {
    DentistDTO dentistDTO = dentistToDentistDTO.apply(dentist);
    if (dentist.getPatients().size() > 0) {
      for (PatientEntity patient : dentist.getPatients()) {
        PatientDTO patientDTO = convert(patient);
        dentistDTO.getPatients().add(patientDTO);
      }
    }
    return dentistDTO;
  }

  public static PatientDTO convertDeep(PatientEntity patient) {
    PatientDTO patientDTO = convert(patient);
    Set<ToothDTO> upLeftToothDTOSet = patient.getTeeth().stream().filter(t -> t.getToothBucket() == ToothBucket.UP_LEFT).map(convertToothToToothDto).collect(Collectors.toSet());
    Set<ToothDTO> upRightToothDTOSet = patient.getTeeth().stream().filter(t -> t.getToothBucket() == ToothBucket.UP_RIGHT).map(convertToothToToothDto).collect(Collectors.toSet());
    Set<ToothDTO> downLeftToothDTOSet = patient.getTeeth().stream().filter(t -> t.getToothBucket() == ToothBucket.DOWN_LEFT).map(convertToothToToothDto).collect(Collectors.toSet());
    Set<ToothDTO> downRightToothDTOSet = patient.getTeeth().stream().filter(t -> t.getToothBucket() == ToothBucket.DOWN_RIGHT).map(convertToothToToothDto).collect(Collectors.toSet());

    patientDTO.getTeeth().setTeethUL(upLeftToothDTOSet);
    patientDTO.getTeeth().setTeethUR(upRightToothDTOSet);
    patientDTO.getTeeth().setTeethDL(downLeftToothDTOSet);
    patientDTO.getTeeth().setTeethDR(downRightToothDTOSet);

    return patientDTO;
  }

  public static ToothDTO convert(ToothEntity tooth) {
    return convertToothToToothDto.apply(tooth);
  }

  public static ToothDTO convertDeep(ToothEntity tooth) {
    return convertDeepToothToToothDto.apply(tooth);
  }

  public static PatientEntity convert(PatientDTO patientDTO) {
    return patientDTOToPatient.apply(patientDTO);
  }

  public static PatientDTO convert(PatientEntity patient) {
    return patientToPatientDTO.apply(patient);
  }

  public static Set<PatientDTO> convert(Collection<PatientEntity> patients) {
    return patients.stream().map(patientToPatientDTO).collect(Collectors.toSet());
  }

  public static Set<SearchPatientDTO> convertSearch(Collection<PatientEntity> patients) {
    return patients.stream().map(patientToSearchPatientDTO).collect(Collectors.toSet());
  }

  public static ToothCureDTO convert(ToothCureEntity toothCure) {
    ToothCureDTO toothCureDTO = new ToothCureDTO();
    toothCureDTO.setCure(toothCure.getCure());
    toothCureDTO.setCreatedOn(toothCure.getCreatedOn());
    toothCureDTO.setId(toothCure.getId());
    return toothCureDTO;
  }

  public static SigninDTO convert(DentalUserDetails dentalUserDetails) {
    return userDetailsToSigninDTO.apply(dentalUserDetails);
  }

  public static Set<DentistDTO> convert(List<DentistEntity> all) {
    return all.stream().map(dentistToDentistDTOShort).collect(Collectors.toSet());
  }
}