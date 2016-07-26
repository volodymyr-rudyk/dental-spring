package com.dental.web.dto;

import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.entity.Tooth;
import com.dental.persistence.entity.ToothCure;
import com.dental.persistence.helperbean.Gender;
import com.dental.persistence.helperbean.ToothBucket;

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
//    Set<ToothCureDTO> toothCureDTOSet = t.getCures().stream().map(convertToothCureToToothCureDto).collect(Collectors.toSet());
//    toothDTO.setCures(toothCureDTOSet);
    return toothDTO;
  };

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
    patientDTO.setId(patient.getId());
    patientDTO.setFirstName(patient.getFirstName());
    patientDTO.setLastName(patient.getLastName());
    patientDTO.setMiddleName(patient.getMiddleName());
    patientDTO.setAddress(patient.getAddress());
    patientDTO.setGender(patient.getGender().name());
    patientDTO.setBirthday(patient.getBirthday());
    patientDTO.setPhone(patient.getPhone());
    return patientDTO;
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