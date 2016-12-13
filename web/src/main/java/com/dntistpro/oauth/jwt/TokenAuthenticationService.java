package com.dntistpro.oauth.jwt;

import com.dntistpro.persistence.entity.UserEntity;
import javafx.beans.binding.ObjectBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vrudyk on 12/3/2016.
 */
@Service
public class TokenAuthenticationService {

  private static final String AUTHORIZATION_HEADER_NAME = "Authorization";

  @Autowired
  private JwtService jwtService;

  @Autowired
  private AuthenticationManager authenticationManager;

  public String addAuthentication(TokenAuthentication tokenAuthentication) {
    TokenAuthentication authentication = (TokenAuthentication) authenticationManager.authenticate(tokenAuthentication);
    JwtInfo jwtInfo = new JwtInfo();
    jwtInfo.setId(authentication.getId());
    jwtInfo.setPrincipal(String.valueOf(authentication.getPrincipal()));
    List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    jwtInfo.setAuthorities(authorities);
    return jwtService.generateJwtToken(jwtInfo);
  }

  public Authentication getAuthentication(HttpServletRequest request) {
    final String token = request.getHeader(AUTHORIZATION_HEADER_NAME);
    if (token != null) {
      JwtInfo jwtInfo = jwtService.parseJwtToken(token);
      if (jwtInfo != null) {
        List<GrantedAuthority> grantedAuthorities
          = jwtInfo.getAuthorities().stream().map(a -> (GrantedAuthority) () -> a).collect(Collectors.toList());
        return new TokenAuthentication(jwtInfo.getId(), jwtInfo.getPrincipal(), grantedAuthorities);
      }
    }
    return null;
  }
}
