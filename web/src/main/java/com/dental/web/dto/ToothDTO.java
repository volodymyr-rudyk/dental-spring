package com.dental.web.dto;

import com.dental.persistence.entity.ToothCure;
import com.dental.persistence.helperbean.ToothState;

import java.util.Set;

/**
 * Created by vrudyk on 7/4/2016.
 */
public class ToothDTO {
  private Long id;
  private Set<ToothCure> cures;
  private ToothState toothState;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<ToothCure> getCures() {
    return cures;
  }

  public void setCures(Set<ToothCure> cures) {
    this.cures = cures;
  }

  public ToothState getToothState() {
    return toothState;
  }

  public void setToothState(ToothState toothState) {
    this.toothState = toothState;
  }
}
