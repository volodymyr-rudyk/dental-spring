package com.dental.web.dto;

import com.dental.persistence.helperbean.ToothBucket;
import com.dental.persistence.helperbean.ToothState;

import java.util.Set;

/**
 * Created by vrudyk on 7/4/2016.
 */
public class ToothDTO extends BaseDTO {
  private Long id;
  private Set<ToothCureDTO> cures;
  private String toothState;
  private ToothBucket toothBucket;
  private Integer toothNumber;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<ToothCureDTO> getCures() {
    return cures;
  }

  public void setCures(Set<ToothCureDTO> cures) {
    this.cures = cures;
  }

  public String getToothState() {
    return toothState;
  }

  public void setToothState(String toothState) {
    this.toothState = toothState;
  }

  public ToothBucket getToothBucket() {
    return toothBucket;
  }

  public void setToothBucket(ToothBucket toothBucket) {
    this.toothBucket = toothBucket;
  }

  public Integer getToothNumber() {
    return toothNumber;
  }

  public void setToothNumber(Integer toothNumber) {
    this.toothNumber = toothNumber;
  }
}
