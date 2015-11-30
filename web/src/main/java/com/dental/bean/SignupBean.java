package com.dental.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by admin on 20.05.2015.
 */
public class SignupBean extends UserBean {

  @NotNull
  @Size(min = 5, max = 50)
  private String firstName;

  @NotNull
  @Size(min = 5, max = 50)
  private String lastName;

  @NotNull
  private Date birthday;

  @NotNull
  @Size(min = 6, max = 50)
  private String password;

  private String phone;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
