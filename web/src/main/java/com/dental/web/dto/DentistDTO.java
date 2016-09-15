package com.dental.web.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by light on 5/6/2016.
 */
public class DentistDTO extends BaseDTO {
  private String firstName;
  private String middleName;
  private String lastName;
  private String address;
  private Date birthday;
  private String phone;

  private Set<PatientDTO> patients = new HashSet<>(0);

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Set<PatientDTO> getPatients() {
    return patients;
  }

  public void setPatients(Set<PatientDTO> patients) {
    this.patients = patients;
  }
}
