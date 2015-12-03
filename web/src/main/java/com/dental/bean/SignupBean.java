package com.dental.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by admin on 20.05.2015.
 */
public class SignupBean extends SigninBean {

  private String confirmPassword;
  private String firstName;
  private String middleName;
  private String lastName;
  private Date birthday;
  private String phone;

  @NotNull
  @Size(min = 6, max = 50)
  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

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
  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

//  @Digits.List({
//      @Digits(integer = 0, fraction = 0),
//      @Digits(integer = 1, fraction = 1),
//      @Digits(integer = 2, fraction = 2),
//      @Digits(integer = 3, fraction = 3),
//      @Digits(integer = 4, fraction = 4),
//      @Digits(integer = 5, fraction = 5),
//      @Digits(integer = 6, fraction = 6),
//      @Digits(integer = 7, fraction = 7),
//      @Digits(integer = 8, fraction = 8),
//      @Digits(integer = 9, fraction = 9),
//  })
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
