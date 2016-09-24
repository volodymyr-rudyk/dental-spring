package com.dental.persistence.helperbean;

/**
 * Created by vrudyk on 7/21/2016.
 */
public enum ToothBucket {
  UP_LEFT("teethUL"),
  UP_RIGHT("teethUR"),
  DOWN_LEFT("teethDL"),
  DOWN_RIGHT("teethDR");

  private String bucketName;
  ToothBucket(String bucketName){
    this.bucketName = bucketName;
  }

  public String getBucketName() {
    return this.bucketName;
  }
}
