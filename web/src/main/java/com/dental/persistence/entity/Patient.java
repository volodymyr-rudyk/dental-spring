package com.dental.persistence.entity;

import com.dental.persistence.helperbean.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by light on 5/9/2015.
 */

@Entity
@Table(name = "patient")
public class Patient extends BaseEntity implements Serializable {

  private String email;
  private String firstName;
  private String middleName;
  private String lastName;
  private String address;
  private Date birthday;
  private Gender gender;
  private String phone;
  private Set<Dentist> dentists = new HashSet<>(0);
  private Set<Tooth> teeth = new HashSet<>(0);

  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "middle_name")
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @Column(name = "last_name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Column(name = "birthday")
  @Temporal(TemporalType.DATE)
  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Column(name = "phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "patients")
  public Set<Dentist> getDentists() {
    return dentists;
  }

  public void setDentists(Set<Dentist> dentists) {
    this.dentists = dentists;
  }

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "patient_id")
  public Set<Tooth> getTeeth() {
    return teeth;
  }

  public void setTeeth(Set<Tooth> teeth) {
    this.teeth = teeth;
  }
}