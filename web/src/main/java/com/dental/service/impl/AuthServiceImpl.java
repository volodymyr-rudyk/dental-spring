package com.dental.service.impl;

import com.dental.bean.SigninBean;
import com.dental.bean.SignupBean;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Patient;
import com.dental.persistence.entity.User;
import com.dental.persistence.helperbean.Gender;
import com.dental.persistence.repository.UserRepository;
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
//    user = userRepository.save(user);

    Dentist dentist = user.getDentist();
    Patient p = new Patient();
    p.setFirstName("first name");
    p.setLastName("last name");
    p.setMiddleName("middle name");
    p.setBirthday(new Date());
    p.setGender(Gender.Mail);
    p.setEmail("fsdfsfsdf");


    Patient p2 = new Patient();
    p2.setFirstName("first name");
    p2.setLastName("last name");
    p2.setMiddleName("middle name");
    p2.setBirthday(new Date());
    p2.setGender(Gender.Mail);
    p2.setEmail("fsdfsfsdf");


    dentist.getPatients().add(p);
    dentist.getPatients().add(p2);
    userRepository.save(user);
  }

  private User getUser(SignupBean signupBean) {
    User user = new User();
    user.setIsEnabled(true);
    user.setEmail(signupBean.getEmail());
    user.setPassword(signupBean.getPassword());

    Dentist dentist = new Dentist();
    dentist.setFirstName(signupBean.getFirstName());
    dentist.setMiddleName("fff");
    dentist.setBirthday(new Date());
    dentist.setAddress("dsds");
    dentist.setPhone("fdfdfd");
//    profile.setMiddleName(signupBean.getMiddleName());
    dentist.setLastName(signupBean.getLastName());
//    profile.setPhone(signupBean.getPhone());
//    profile.setAddress(signupBean.getAddress());


    user.setDentist(dentist);
    return user;
  }
}
