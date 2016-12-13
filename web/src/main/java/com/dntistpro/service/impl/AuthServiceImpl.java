package com.dntistpro.service.impl;

import com.dntistpro.web.request.LoginRequest;
import com.dntistpro.web.request.legacy.SignupBean;
import com.dntistpro.exception.RequiredAuthenticationException;
import com.dntistpro.oauth.jwt.TokenAuthentication;
import com.dntistpro.oauth.jwt.TokenAuthenticationService;
import com.dntistpro.oauth.jwt.UserAuthentication;
import com.dntistpro.persistence.entity.DentistEntity;
import com.dntistpro.persistence.entity.LanguageEntity;
import com.dntistpro.persistence.entity.UserEntity;
import com.dntistpro.persistence.repository.LanguageRepository;
import com.dntistpro.persistence.repository.UserRepository;
import com.dntistpro.provider.DentalUserDetails;
import com.dntistpro.service.AuthService;
import com.dntistpro.web.helper.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by light on 5/3/2015.
 */
@Service
public class AuthServiceImpl implements AuthService {

  private static final Logger LOG = LoggerFactory.getLogger(AuthServiceImpl.class);
  public static final String DEFAULT_LANGUAGE = "en";

  @Autowired
  private LogoutHandler logoutHandler;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private LanguageRepository languageRepository;

  @Autowired
  TokenAuthenticationService tokenAuthenticationService;

  @Override
  public String authenticateToken(LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    LOG.info("Authentication started... " + loginRequest);
    TokenAuthentication tokenAuthentication = new TokenAuthentication(loginRequest.getEmail(), loginRequest.getPassword());
    String token = tokenAuthenticationService.addAuthentication(tokenAuthentication);
    LOG.info("Generated token {}", token);
    return token;
//    return (UserDetails) authentication.getPrincipal();
  }

  @Override
  public UserDetails authenticate(LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    return null;
//    LOG.info("Authentication started... " + loginRequest);
//    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
//    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
//    Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//
//    if (authentication.isAuthenticated()) {
//      SecurityContextHolder.getContext().setAuthentication(authentication);
//    }
//
//    LOG.info("Authentication completed.");
//    return (UserDetails) authentication.getPrincipal();
  }

  @Override
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    logoutHandler.logout(request, response, authentication);
  }

  @Override
  public void signup(SignupBean signupBean) {
    Language language = Language.from(signupBean.getLanguage());
    UserEntity user = getUser(signupBean);
    LanguageEntity en = languageRepository.findOneByCode(language.code());
    user.setLanguage(en);
    userRepository.save(user);
  }

  @Override
  public DentistEntity getLoggedInDentist() {
    DentalUserDetails dentalUserDetails = this.loadUserDetails();
    return dentalUserDetails.getUser().getDentist();
  }

  private DentalUserDetails loadUserDetails() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null) {
      throw new RequiredAuthenticationException("getLoggedInProfile");
    }
    return (DentalUserDetails) authentication.getPrincipal();
  }

  private UserEntity getUser(SignupBean signupBean) {
    UserEntity user = new UserEntity();
    user.setIsEnabled(true);
    user.setEmail(signupBean.getEmail());
    user.setPassword(signupBean.getPassword());
    user.setCreatedOn(new Date());

    DentistEntity dentist = new DentistEntity();
    dentist.setFirstName(signupBean.getFirstName());
    dentist.setLastName(signupBean.getLastName());
    dentist.setUser(user);
    user.setDentist(dentist);
    return user;
  }
}
