package com.dntistpro.provider;

import com.dntistpro.oauth.jwt.TokenAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Created by vrudyk on 12/4/2016.
 */
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

  private static final Logger LOG = LoggerFactory.getLogger(TokenAuthenticationProvider.class);

  @Autowired
  @Qualifier("tokenUserDetailsService")
  private UserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    LOG.info(authentication.getPrincipal() + " = " + authentication.getCredentials());

    String userName = authentication.getPrincipal().toString();
    String password = authentication.getCredentials().toString();

    TokenUserDetails userDetails = (TokenUserDetails) userDetailsService.loadUserByUsername(userName);

    if (!userDetails.getPassword().equals(password)) {
      throw new BadCredentialsException("user name not found, bad credentials");
    }
    return new TokenAuthentication(userDetails.getId(), userDetails.getUsername(), userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication == TokenAuthentication.class;
  }
}
