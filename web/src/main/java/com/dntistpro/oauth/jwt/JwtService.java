package com.dntistpro.oauth.jwt;

/**
 * Created by vrudyk on 12/9/2016.
 */
public interface JwtService {

  String JWT_INFO = "jwtInfo";

  String generateJwtToken(JwtInfo jwtInfo);

  JwtInfo parseJwtToken(String token);

}
