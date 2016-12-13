package com.dntistpro.oauth.jwt;

import com.google.common.base.Preconditions;

/**
 * Created by vrudyk on 12/3/2016.
 */
public final class StringConditions {
  private StringConditions() { }

  public static String checkNotBlank(String string) {
    Preconditions.checkArgument(string != null && string.trim().length() > 0);
    return string;
  }
}
