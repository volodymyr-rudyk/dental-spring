package com.dental.web.dto;

import com.dental.persistence.helperbean.ToothGrid;
import com.dental.persistence.helperbean.ToothState;

import java.util.Set;

/**
 * Created by vrudyk on 7/4/2016.
 */
public class ToothDTO {
  private Long id;
  private Set<ToothCureDTO> cures;
  private ToothState toothState;
  private ToothGrid toothGrid;

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

  public ToothState getToothState() {
    return toothState;
  }

  public void setToothState(ToothState toothState) {
    this.toothState = toothState;
  }

  public ToothGrid getToothGrid() {
    return toothGrid;
  }

  public void setToothGrid(ToothGrid toothGrid) {
    this.toothGrid = toothGrid;
  }
}
