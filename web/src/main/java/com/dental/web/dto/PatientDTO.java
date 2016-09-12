package com.dental.web.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by light on 5/6/2016.
 */
public class PatientDTO extends BaseDTO {
  private Long id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String address;
  private Date birthday;
  private String gender;
  private String phone;

  private Set<ToothDTO> teethUL = new HashSet<>();
  private Set<ToothDTO> teethUR = new HashSet<>();
  private Set<ToothDTO> teethDL = new HashSet<>();
  private Set<ToothDTO> teethDR = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Set<ToothDTO> getTeethUL() {
    return teethUL;
  }

  public void setTeethUL(Set<ToothDTO> teethUL) {
    this.teethUL = teethUL;
  }

  public Set<ToothDTO> getTeethUR() {
    return teethUR;
  }

  public void setTeethUR(Set<ToothDTO> teethUR) {
    this.teethUR = teethUR;
  }

  public Set<ToothDTO> getTeethDL() {
    return teethDL;
  }

  public void setTeethDL(Set<ToothDTO> teethDL) {
    this.teethDL = teethDL;
  }

  public Set<ToothDTO> getTeethDR() {
    return teethDR;
  }

  public void setTeethDR(Set<ToothDTO> teethDR) {
    this.teethDR = teethDR;
  }
}
