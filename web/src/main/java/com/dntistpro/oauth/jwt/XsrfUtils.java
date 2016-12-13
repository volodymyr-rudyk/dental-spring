package com.dntistpro.oauth.jwt;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by vrudyk on 12/3/2016.
 */
public class XsrfUtils {
  public static final String XSRF_KEY = "xsrf-token";

  /**
   * @return a new unique cross-site request forgery token
   */
  public String newToken() {
    return new BigInteger(130, new SecureRandom()).toString(32);
  }

  /**
   * Compares two cross-site request forgery tokens. Will always return false if the expected token is
   * null to prevent new session hijacking.
   *
   * @param expectedToken the value of the original XSRF token
   * @param actualToken the value received from the client
   * @return true if the expected token is non-null and the tokens match, false otherwise
   */
  public boolean isValid(String expectedToken, String actualToken) {
    return expectedToken != null && expectedToken.equals(actualToken);
  }
}