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
  private Date createdOn;

  private TeethBucketDto teeth = new TeethBucketDto();

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

  public TeethBucketDto getTeeth() {
    return teeth;
  }

  public void setTeeth(TeethBucketDto teeth) {
    this.teeth = teeth;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }
}
