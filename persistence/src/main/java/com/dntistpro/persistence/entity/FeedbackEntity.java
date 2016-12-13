package com.dntistpro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by vrudyk on 10/14/2016.
 */
@Entity
@Table(name = "feedback")
public class FeedbackEntity extends BaseEntity {
  private String email;
  private String feedback;

  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "feedback")
  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }
}
