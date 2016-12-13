package com.dntistpro.oauth.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by vrudyk on 12/9/2016.
 */
@Service
public class JwtServiceImpl implements JwtService {

  private String secret;
  private String key = "secret";
  private String issue = "dntistpro";
  private String subject = "accesstoken";

  @PostConstruct
  public void init() {
    this.secret = Base64.getEncoder().encodeToString(StringConditions.checkNotBlank(key).getBytes());
  }

  @Override
  public String generateJwtToken(JwtInfo jwtInfo) {
    Date now = new Date();
    Date expiration = new Date(now.getTime() + TimeUnit.HOURS.toMillis(1l));

    Map<String, Object> jwtInfoMap = new HashMap<>();
    jwtInfoMap.put(JWT_INFO, jwtInfo);

    return Jwts.builder()
      .setId(UUID.randomUUID().toString())
      .setIssuer(issue)
      .setSubject(subject)
      .setClaims(jwtInfoMap)
      .setIssuedAt(now)
      .setExpiration(expiration)
      .signWith(SignatureAlgorithm.HS512, secret)
      .compact();
  }

  @Override
  public JwtInfo parseJwtToken(String token) {
    LinkedHashMap map = Jwts.parser()
      .setSigningKey(secret)
      .parseClaimsJws(token)
      .getBody()
      .get(JWT_INFO, LinkedHashMap.class);
    return JwtInfo.from(map);
  }
}
