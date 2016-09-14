package com.dental.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by light on 5/9/2015.
 */

@Entity
@Table(name = "dentist_patient")
public class DentistPatient extends BaseEntity implements Serializable {

  private Dentist dentist;
  private Patient patient;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "dentist_id")
  public Dentist getDentist() {
    return dentist;
  }

  public void setDentist(Dentist dentist) {
    this.dentist = dentist;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "patient_id")
  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }
}
