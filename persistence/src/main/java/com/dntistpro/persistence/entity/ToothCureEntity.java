package com.dntistpro.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by vrudyk on 7/2/2016.
 */
@Entity
@Table(name = "tooth_cure")
public class ToothCureEntity extends BaseEntity implements Serializable {

  private String cure;
  private Date createdOn;
  private ToothEntity tooth;
  private DentistEntity dentist;

  public ToothCureEntity() {

  }

  public ToothCureEntity(String cure) {
    this.cure = cure;
  }

  @Column(name = "cure")
  public String getCure() {
    return cure;
  }

  public void setCure(String cure) {
    this.cure = cure;
  }

  @Column(name = "created_on")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  @ManyToOne
  public ToothEntity getTooth() {
    return tooth;
  }

  public void setTooth(ToothEntity tooth) {
    this.tooth = tooth;
  }

  @ManyToOne
  public DentistEntity getDentist() {
    return dentist;
  }

  public void setDentist(DentistEntity dentist) {
    this.dentist = dentist;
  }
}
