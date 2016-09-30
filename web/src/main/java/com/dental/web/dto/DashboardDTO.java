package com.dental.web.dto;

/**
 * Created by vrudyk on 9/12/2016.
 */
public class DashboardDTO extends BaseDTO {

  DentistDTO dentist;
  Long patientsCount;
  Long curesCount;

  public DentistDTO getDentist() {
    return dentist;
  }

  public void setDentist(DentistDTO dentist) {
    this.dentist = dentist;
  }

  public Long getPatientsCount() {
    return patientsCount;
  }

  public void setPatientsCount(Long patientsCount) {
    this.patientsCount = patientsCount;
  }

  public Long getCuresCount() {
    return curesCount;
  }

  public void setCuresCount(Long curesCount) {
    this.curesCount = curesCount;
  }
}
