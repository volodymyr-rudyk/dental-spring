package com.dental.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by light on 1/27/2015.
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

  private Long id;
  private String email;
  private String password;
  private boolean isEnabled;
  private Dentist dentist;

  public User() {

  }

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

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

  @Column(name = "is_enabled")
  public boolean getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "dentist_id")
  public Dentist getDentist() {
    return dentist;
  }

  public void setDentist(Dentist dentist) {
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

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", isEnabled=" + isEnabled +
        ", dentist=" + dentist +
        '}';
  }
}
