package com.dental.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by admin on 20.05.2015.
 */
public class SignupBean extends SigninBean {

  private String firstName;
  private String middleName;
  private String lastName;
  private String address;
  private Date birthday;
  private String phone;

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @NotNull
  @Size(min = 5, max = 50)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @NotNull
  @Size(min = 5, max = 50)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @NotNull
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @NotNull
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
}
