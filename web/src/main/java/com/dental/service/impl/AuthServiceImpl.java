package com.dental.service.impl;

import com.dental.bean.SigninBean;
import com.dental.bean.SignupBean;
import com.dental.exception.RequiredAuthenticationException;
import com.dental.persistence.entity.DentistEntity;
import com.dental.persistence.entity.LanguageEntity;
import com.dental.persistence.entity.UserEntity;
import com.dental.persistence.repository.LanguageRepository;
import com.dental.persistence.repository.UserRepository;
import com.dental.provider.DentalUserDetails;
import com.dental.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
  @Qualifier("dentalAuthenticationManager")
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private LanguageRepository languageRepository;

  @Override
  public UserDetails authenticate(SigninBean signinBean, HttpServletRequest request) throws AuthenticationException {
    LOG.info("Authentication started... " + signinBean);
    UsernamePasswordAuthenticationToken token =
        new UsernamePasswordAuthenticationToken(signinBean.getEmail(), signinBean.getPassword());
    token.setDetails(new WebAuthenticationDetails(request));
    Authentication authentication = authenticationManager.authenticate(token);

    if (authentication.isAuthenticated()) {
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    LOG.info("Authentication completed.");
    return (UserDetails) authentication.getPrincipal();
  }

  @Override
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    logoutHandler.logout(request, response, authentication);
  }

  @Override
  public void signup(SignupBean signupBean) {
    UserEntity user = getUser(signupBean);
    LanguageEntity en = languageRepository.findOneByCode(DEFAULT_LANGUAGE);
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
    if (authentication == null) throw new RequiredAuthenticationException("getLoggedInProfile");
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
    LanguageEntity language = new LanguageEntity();
    language.setCode(DEFAULT_LANGUAGE);
    user.setLanguage(language);
    return user;
  }
}
