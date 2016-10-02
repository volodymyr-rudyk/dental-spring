package com.dental.bean.request;

import com.dental.persistence.helperbean.ToothState;

/**
 * Created by vrudyk on 10/2/2016.
 */
public class ToothStateBean {
  private Long patientId;
  private Long toothId;
  private String toothState;

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public Long getToothId() {
    return toothId;
  }

  public void setToothId(Long toothId) {
    this.toothId = toothId;
  }

  public String getToothState() {
    return toothState;
  }

  public void setToothState(String toothState) {
    this.toothState = toothState;
  }

  public ToothState ToothState() {
    return ToothState.get(toothState);
  }
}
