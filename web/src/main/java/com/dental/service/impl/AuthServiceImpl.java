package com.dental.service.impl;

import com.dental.bean.SigninBean;
import com.dental.bean.SignupBean;
import com.dental.exception.RequiredAuthenticationException;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.User;
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

  @Autowired
  private LogoutHandler logoutHandler;

  @Autowired
  @Qualifier("dentalAuthenticationManager")
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Override
  public void authenticate(SigninBean signinBean, HttpServletRequest request) throws AuthenticationException {
    LOG.info("Authentication started... " + signinBean);
    UsernamePasswordAuthenticationToken token =
        new UsernamePasswordAuthenticationToken(signinBean.getEmail(), signinBean.getPassword());
    token.setDetails(new WebAuthenticationDetails(request));
    Authentication authentication = authenticationManager.authenticate(token);
//        Authentication authentication = authenticationProvider.authenticate(token);

//    SecurityContext securityContext = SecurityContextHolder.getContext();
//    securityContext.setAuthentication(authentication);
//    HttpSession session = request.getSession(true);
//    session.setAttribute(SPRING_SECURITY_CONTEXT, securityContext);

    if (authentication.isAuthenticated()) {
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

//    SecurityContext sc = new SecurityContextImpl();
//    sc.setAuthentication(authentication);
//    SecurityContextHolder.setContext(sc);
    LOG.info("Authentication completed.");
  }

  @Override
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    logoutHandler.logout(request, response, authentication);
  }

  @Override
  public void signup(SignupBean signupBean) {
    User user = getUser(signupBean);
    userRepository.save(user);
  }

  @Override
  public User getLoggedUser() {
    DentalUserDetails dentalUserDetails = this.loadUserDetails();
    return dentalUserDetails.getUser();
  }

  private DentalUserDetails loadUserDetails() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null) throw new RequiredAuthenticationException("getLoggedInProfile");
    return (DentalUserDetails) authentication.getPrincipal();
  }

  @Override
  public Dentist getLoggedInDentist() {
    DentalUserDetails dentalUserDetails = this.loadUserDetails();
    return dentalUserDetails.getUser().getDentist();
  }

  private User getUser(SignupBean signupBean) {
    User user = new User();
    user.setIsEnabled(true);
    user.setEmail(signupBean.getEmail());
    user.setPassword(signupBean.getPassword());
    user.setCreatedOn(new Date());

    Dentist dentist = new Dentist();
    dentist.setFirstName(signupBean.getFirstName());
    dentist.setLastName(signupBean.getLastName());
    dentist.setUser(user);
    user.setDentist(dentist);
    return user;
  }
}
