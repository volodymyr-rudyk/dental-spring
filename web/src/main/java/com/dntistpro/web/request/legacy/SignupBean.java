package com.dntistpro.web.request.legacy;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by admin on 20.05.2015.
 */
public class SignupBean {

  private String firstName;
  //  private String middleName;
  private String lastName;
  //  private String address;
//  private Date birthday;
//  private String phone;
  private String language;
  private String email;
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  //  public String getMiddleName() {
//    return middleName;
//  }

//  public void setMiddleName(String middleName) {
//    this.middleName = middleName;
//  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @NotNull
  @Size(min = 1, max = 255)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @NotNull
  @Size(min = 1, max = 255)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

//  @NotNull
//  public String getAddress() {
//    return address;
//  }

//  public void setAddress(String address) {
//    this.address = address;
//  }

//  @NotNull
//  public Date getBirthday() {
//    return birthday;
//  }

//  public void setBirthday(Date birthday) {
//    this.birthday = birthday;
//  }

//  public String getPhone() {
//    return phone;
//  }

//  public void setPhone(String phone) {
//    this.phone = phone;
//  }
}
