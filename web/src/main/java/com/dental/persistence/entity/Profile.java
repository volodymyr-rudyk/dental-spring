package com.dental.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by light on 5/9/2015.
 */

@Entity
@Table(name = "profile")
public class Profile extends BaseEntity implements Serializable {

  private Integer id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String address;
  private Date birthday;
  private String phone;
  private User user;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Override
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "profile")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
