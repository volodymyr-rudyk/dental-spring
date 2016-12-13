package com.dntistpro.provider;

/**
 * Created by vrudyk on 12/4/2016.
 */

import com.dntistpro.persistence.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by admin on 27.05.2015.
 */
public class TokenUserDetails implements UserDetails {

  private Collection<? extends GrantedAuthority> grantedAuthorities;
  private String password;
  private String username;
  private String id;
  //  private boolean isAccountNonLocked;
  //  private boolean isAccountNonExpired;
//  private UserEntity user;

  public TokenUserDetails(String id, String username, String password, Collection<? extends GrantedAuthority> grantedAuthorities/*, UserEntity user*/) {
    this.id = id;
    this.username = username;
    this.password = password;
    //    this.isAccountNonExpired = isAccountNonExpired;
    //    this.isAccountNonLocked = isAccountNonLocked;
    this.grantedAuthorities = grantedAuthorities;
//    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public String getId() {
    return id;
  }

  //  public UserEntity getUser() {
//    return this.user;
//  }
}
