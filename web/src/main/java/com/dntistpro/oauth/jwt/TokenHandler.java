//package com.dntistpro.oauth.jwt;
//
//import com.dntistpro.persistence.entity.UserEntity;
//import com.dntistpro.provider.DentalUserDetails;
//import com.google.common.base.Preconditions;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//import java.util.Base64;
//import java.util.Date;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by vrudyk on 12/3/2016.
// */
//
//@Component
//public final class TokenHandler {
//
//  private final String secret;
//  private final String key = "secret";
//
//  @Autowired
//  @Qualifier("tokenUserDetailsService")
//  private UserDetailsService userDetailsService;
//
//  public TokenHandler() {
//    this.secret = Base64.getEncoder().encodeToString(StringConditions.checkNotBlank(key).getBytes());
//  }
//
//  public UserDetails parseUserFromToken(String token) {
//    String username = Jwts.parser()
//      .setSigningKey(secret)
//      .parseClaimsJws(token)
//      .getBody()
//      .getSubject();
//    return  userDetailsService.loadUserByUsername(username);
//  }
//
//  public String createTokenForUser(User user) {
//    Date now = new Date();
//    Date expiration = new Date(now.getTime() + TimeUnit.HOURS.toMillis(1l));
//    return Jwts.builder()
//      .setId(UUID.randomUUID().toString())
//      .setSubject(user.getUsername())
//      .setIssuedAt(now)
//      .setExpiration(expiration)
//      .signWith(SignatureAlgorithm.HS512, secret)
//      .compact();
//  }
//}
