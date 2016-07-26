package com.dental.persistence.entity;

import com.dental.persistence.helperbean.ToothBucket;
import com.dental.persistence.helperbean.ToothState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vrudyk on 7/2/2016.
 */
@Entity
@Table(name = "tooth")
public class Tooth extends BaseEntity implements Serializable{

  private Long id;
  private ToothState toothState;
  private ToothBucket toothBucket;
  private Integer toothNumber;
  private Set<ToothCure> cures = new HashSet<>();
  private Patient patient;


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

  @Column(name = "tooth_state")
  @Enumerated(EnumType.STRING)
  public ToothState getToothState() {
    return toothState;
  }

  public void setToothState(ToothState toothState) {
    this.toothState = toothState;
  }

  @Column(name = "tooth_bucket")
  @Enumerated(EnumType.STRING)
  public ToothBucket getToothBucket() {
    return toothBucket;
  }

  public void setToothBucket(ToothBucket toothBucket) {
    this.toothBucket = toothBucket;
  }

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "tooth_id")
  public Set<ToothCure> getCures() {
    return cures;
  }

  public void setCures(Set<ToothCure> cures) {
    this.cures = cures;
  }

  @ManyToOne
  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  @Column(name = "tooth_number")
  public Integer getToothNumber() {
    return toothNumber;
  }

  public void setToothNumber(Integer toothNumber) {
    this.toothNumber = toothNumber;
  }
}
