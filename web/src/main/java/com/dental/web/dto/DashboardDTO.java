package com.dental.web.dto;

/**
 * Created by vrudyk on 9/12/2016.
 */
public class DashboardDTO extends BaseDTO {

  DentistDTO dentist;
  Long patientsCount;

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
}
