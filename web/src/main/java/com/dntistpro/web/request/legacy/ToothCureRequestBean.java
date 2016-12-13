package com.dntistpro.web.request.legacy;

import com.dntistpro.bean.RequestBean;

/**
 * Created by vrudyk on 7/4/2016.
 */
public class ToothCureRequestBean implements RequestBean {

  private Long patientId;
  private Long toothId;
  private String cure;

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

  public String getCure() {
    return cure;
  }

  public void setCure(String cure) {
    this.cure = cure;
  }
}
