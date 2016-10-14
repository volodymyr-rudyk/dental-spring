package com.dental.web.dto;

/**
 * Created by light on 10/14/2016.
 */
public class FeedbackDTO extends BaseDTO {
  private String email;
  private String feedback;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }
}
