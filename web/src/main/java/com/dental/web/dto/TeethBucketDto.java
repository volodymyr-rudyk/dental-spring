package com.dental.web.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vrudyk on 9/24/2016.
 */
public class TeethBucketDto {

  private Set<ToothDTO> teethUL = new HashSet<>();
  private Set<ToothDTO> teethUR = new HashSet<>();
  private Set<ToothDTO> teethDL = new HashSet<>();
  private Set<ToothDTO> teethDR = new HashSet<>();

  public Set<ToothDTO> getTeethUL() {
    return teethUL;
  }

  public void setTeethUL(Set<ToothDTO> teethUL) {
    this.teethUL = teethUL;
  }

  public Set<ToothDTO> getTeethUR() {
    return teethUR;
  }

  public void setTeethUR(Set<ToothDTO> teethUR) {
    this.teethUR = teethUR;
  }

  public Set<ToothDTO> getTeethDL() {
    return teethDL;
  }

  public void setTeethDL(Set<ToothDTO> teethDL) {
    this.teethDL = teethDL;
  }

  public Set<ToothDTO> getTeethDR() {
    return teethDR;
  }

  public void setTeethDR(Set<ToothDTO> teethDR) {
    this.teethDR = teethDR;
  }
}
