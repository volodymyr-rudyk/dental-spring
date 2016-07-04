package com.dental.bean;

/**
 * Created by vrudyk on 7/4/2016.
 */
public class ToothRequestBean implements RequestBean {

  private Long patientId;
  private Long toothId;

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
}
