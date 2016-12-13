package com.dntistpro.oauth.jwt;

import org.hibernate.dialect.HANAColumnStoreDialect;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

/**
 * Created by vrudyk on 12/10/2016.
 */
public class JwtInfo {

  private static final String KEY_ID = "id";
  private static final String KEY_PRINCIPAL = "principal";
  private static final String KEY_AUTHORITIES = "authorities";


  private String id;
  private String principal;
  private Collection<String> authorities;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPrincipal() {
    return principal;
  }

  public void setPrincipal(String principal) {
    this.principal = principal;
  }

  public Collection<String> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Collection<String> authorities) {
    this.authorities = authorities;
  }

  public static JwtInfo from(Map<String, Object> map) {
    JwtInfo jwtInfo = new JwtInfo();
    jwtInfo.setId(String.valueOf((map.get(KEY_ID))));
    jwtInfo.setPrincipal(String.valueOf((map.get(KEY_PRINCIPAL))));
    jwtInfo.setAuthorities((Collection<String>)map.get(KEY_AUTHORITIES));
    return jwtInfo;
  }
}
