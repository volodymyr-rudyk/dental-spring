package com.dntistpro.persistence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vrudyk on 9/7/2016.
 */
@Entity
@Table(name = "forgot_password")
public class ForgotPasswordEntity extends BaseEntity {

  private String forgotPasswordKey;
  private Date createdOn;
  private Date usedOn;
  private UserEntity user;

  @Column(name = "forgot_password_key", nullable = false, length = 50)
  public String getForgotPasswordKey() {
    return forgotPasswordKey;
  }

  public void setForgotPasswordKey(String forgotPasswordKey) {
    this.forgotPasswordKey = forgotPasswordKey;
  }

  @Column(name = "created_on", nullable = false)
  @Temporal(TemporalType.DATE)
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  @Column(name = "used_on")
  @Temporal(TemporalType.DATE)
  public Date getUsedOn() {
    return usedOn;
  }

  public void setUsedOn(Date usedOn) {
    this.usedOn = usedOn;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }
}
