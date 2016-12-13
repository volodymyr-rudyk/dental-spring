package com.dntistpro.service.impl;

import com.dntistpro.persistence.entity.UserEntity;
import com.dntistpro.persistence.repository.UserRepository;
import com.dntistpro.provider.DentalUserDetails;
import com.dntistpro.provider.TokenUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrudyk on 12/4/2016.
 */
@Service("tokenUserDetailsService")
public class TokenUserDetailsServiceImpl implements UserDetailsService {

  private static SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
  private static SimpleGrantedAuthority roleUser = new SimpleGrantedAuthority("ROLE_USER");

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
    final UserEntity user = userRepository.findByEmail(email);
    if (user == null)
      throw new UsernameNotFoundException("user name not found" + email);

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(roleUser);
    return new TokenUserDetails(String.valueOf(user.getId()), user.getEmail(), user.getPassword(), authorities);
  }
}