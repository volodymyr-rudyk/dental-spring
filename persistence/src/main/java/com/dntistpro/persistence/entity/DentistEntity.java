package com.dntistpro.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by light on 5/9/2015.
 */

@Entity
@Table(name = "dentist")
public class DentistEntity extends BaseEntity implements Serializable {

  private String firstName;
  private String middleName;
  private String lastName;
  private String address;
  private Date birthday;
  private String phone;
  private Date createdOn;
  private UserEntity user;
  private Set<PatientEntity> patients = new HashSet<>(0);
  private Set<ToothCureEntity> cures = new HashSet<>();

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

  @Column(name = "phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Column(name = "created_on")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "dentist_patient",
      joinColumns = { @JoinColumn(name = "dentist_id") },
      inverseJoinColumns = { @JoinColumn(name = "patient_id") }
  )
  public Set<PatientEntity> getPatients() {
    return patients;
  }

  public void setPatients(Set<PatientEntity> patients) {
    this.patients = patients;
  }

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "dentist_id")
  public Set<ToothCureEntity> getCures() {
    return cures;
  }

  public void setCures(Set<ToothCureEntity> cures) {
    this.cures = cures;
  }

  @PrePersist
  public void prePersist(){
    setCreatedOn(new Date());
  }
}
