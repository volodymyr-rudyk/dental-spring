package com.dental.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 06.04.2015.
 */
public class UserDetailsServiceImpl implements UserDetailsService {
  @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if(!"test".equals(username))
      throw new UsernameNotFoundException("user name not found" + username);

    return new UserDetails() {

      @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorityList = new LinkedList<SimpleGrantedAuthority>();

        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorityList;
      }

      @Override public String getPassword() {
        return "test";
      }

      @Override public String getUsername() {
        return "test";
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
        return false;
      }
    };
  }
}