package com.dental.provider;

import com.dental.dao.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by admin on 27.05.2015.
 */
public class DentalUserDetails implements UserDetails {

  private Collection<? extends GrantedAuthority> grantedAuthorities;
  private String password;
  private String username;
  //  private boolean isAccountNonLocked;
  //  private boolean isAccountNonExpired;
  private User user;

  public DentalUserDetails(String username, String password,
          Collection<? extends GrantedAuthority> grantedAuthorities, User user) {
    this.username = username;
    this.password = password;
    //    this.isAccountNonExpired = isAccountNonExpired;
    //    this.isAccountNonLocked = isAccountNonLocked;
    this.grantedAuthorities = grantedAuthorities;
    this.user = user;
  }

  @Override public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.grantedAuthorities;
  }

  @Override public String getPassword() {
    return this.password;
  }

  @Override public String getUsername() {
    return this.username;
  }

  @Override public boolean isAccountNonExpired() {
    return false;
  }

  @Override public boolean isAccountNonLocked() {
    return false;
  }

  @Override public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override public boolean isEnabled() {
    return true;
  }

  public User getUser() {
    return this.user;
  }
}