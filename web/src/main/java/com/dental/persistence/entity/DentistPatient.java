package com.dental.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by light on 5/9/2015.
 */

@Entity
@Table(name = "dentist_patient")
public class DentistPatient extends BaseEntity implements Serializable {

  private DentistEntity dentist;
  private PatientEntity patient;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "dentist_id")
  public DentistEntity getDentist() {
    return dentist;
  }

  public void setDentist(DentistEntity dentist) {
    this.dentist = dentist;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "patient_id")
  public PatientEntity getPatient() {
    return patient;
  }

  public void setPatient(PatientEntity patient) {
    this.patient = patient;
  }
}
