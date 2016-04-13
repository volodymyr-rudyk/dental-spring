package com.dental.persistence.entity;

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
public class Dentist extends BaseEntity implements Serializable {

  private Long id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String address;
  private Date birthday;
  private String phone;
  private User user;
  private Set<Patient> patients = new HashSet<>(0);

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @Column(name = "phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "dentist")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "dentist_patient",
      joinColumns = { @JoinColumn(name = "dentist_id") },
      inverseJoinColumns = { @JoinColumn(name = "patient_id") }
  )
  public Set<Patient> getPatients() {
    return patients;
  }

  public void setPatients(Set<Patient> patients) {
    this.patients = patients;
  }
}
