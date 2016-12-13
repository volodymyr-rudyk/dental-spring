package com.dntistpro.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by vrudyk on 9/30/2016.
 */
@Entity
@Table(name = "language")
public class LanguageEntity extends BaseEntity {
  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
