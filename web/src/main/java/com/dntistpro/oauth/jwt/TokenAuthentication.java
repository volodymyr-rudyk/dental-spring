package com.dntistpro.oauth.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * Created by vrudyk on 12/3/2016.
 */
public class TokenAuthentication implements Authentication {

  private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

  private final Object principal;
  private String id;
  private Object credentials;
  private Collection<? extends GrantedAuthority> authorities;
//  private UserEntity user;
  private boolean authenticated = false;

  public TokenAuthentication(Object principal, Object credentials) {
    this.principal = principal;
    this.credentials = credentials;
  }

  public TokenAuthentication(String id, Object principal, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.principal = principal;
    this.authorities = authorities;
    setAuthenticated(true);
  }

//  public TokenAuthentication(Object principal, Collection<? extends GrantedAuthority> authorities/*, UserEntity user*/) {
//    this.principal = principal;
//    this.authorities = authorities;
//    this.user = user;
//    setAuthenticated(true);
//  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Object getCredentials() {
    return this.credentials;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  public Object getPrincipal() {
    return this.principal;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    this.authenticated = isAuthenticated;
  }

  @Override
  public String getName() {
    return (String) principal;
  }

//  public UserEntity getUser() {
//    return user;
//  }

  public String getId() {
    return id;
  }
}
