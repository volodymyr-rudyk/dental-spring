package com.dntistpro.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by light on 1/27/2015.
 */
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity implements Serializable {

  private String email;
  private String password;
  private boolean isEnabled;
  private Date createdOn;
  private LanguageEntity language;
  private DentistEntity dentist;

  public UserEntity() {

  }

  public UserEntity(String email, String password) {
    this.email = email;
    this.password = password;
  }

  @Column(name = "is_enabled")
  public boolean getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  public DentistEntity getDentist() {
    return dentist;
  }

  public void setDentist(DentistEntity dentist) {
    this.dentist = dentist;
  }

  @Column(name = "email", unique = true, nullable = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "password", nullable = false)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "created_on", nullable = false)
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  @OneToOne
  @JoinColumn(name = "language_id")
  public LanguageEntity getLanguage() {
    return language;
  }

  public void setLanguage(LanguageEntity language) {
    this.language = language;
  }

  @PrePersist
  public void prePersist() {

  }

  @Override
  public String toString() {
    return "UserEntity{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", isEnabled=" + isEnabled +
        ", dentist=" + dentist +
        '}';
  }
}
