package com.dental.web.dto;

import java.util.Date;

/**
 * Created by vrudyk on 7/14/2016.
 */
public class ToothCureDTO {
  private Long id;
  private String cure;
  private Date createdOn;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCure() {
    return cure;
  }

  public void setCure(String cure) {
    this.cure = cure;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }
}
