package com.dntistpro.persistence.entity;

import javax.persistence.*;

/**
 * Created by vrudyk on 12/3/2015.
 */
@MappedSuperclass
public class BaseEntity {

  protected Long id;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
