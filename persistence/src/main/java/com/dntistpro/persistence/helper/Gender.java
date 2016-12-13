package com.dntistpro.persistence.helper;

/**
 * Created by light on 3/20/2016.
 */
public enum Gender {
  Male("Male"),
  Female("Female"),
  Undefined("Undefined");

  private String gender;

  Gender(String gender){
    this.gender = gender;
  }

  public static Gender get(String value) {
    for (Gender gender : Gender.values()) {
      if (gender.name().equalsIgnoreCase(value)) {
        return gender;
      }
    }
    return Gender.Undefined;
  };
}
