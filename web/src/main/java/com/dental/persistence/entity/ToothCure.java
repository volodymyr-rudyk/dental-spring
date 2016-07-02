package com.dental.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by vrudyk on 7/2/2016.
 */
@Entity
@Table(name = "tooth_cure")
public class ToothCure extends BaseEntity implements Serializable {

  private Long id;
  private String cure;
  private Date createdOn;
  private Tooth tooth;

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

  @Column(name = "cure")
  public String getCure() {
    return cure;
  }

  public void setCure(String cure) {
    this.cure = cure;
  }

  @Column(name = "createdOn")
  @Temporal(TemporalType.DATE)
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  @ManyToOne
  public Tooth getTooth() {
    return tooth;
  }

  public void setTooth(Tooth tooth) {
    this.tooth = tooth;
  }
}
