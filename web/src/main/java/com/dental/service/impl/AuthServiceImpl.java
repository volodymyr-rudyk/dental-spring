package com.dental.service.impl;

import com.dental.beans.UserBean;
import com.dental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by light on 5/3/2015.
 */
public class AuthServiceImpl implements AuthService {

    //  @Autowired
//  private ProviderManager providerManager;

    @Autowired
    private LogoutHandler logoutHandler;

    @Autowired
    @Qualifier("dentalAuthenticationManager")
    private AuthenticationManager authenticationManager;

//  @Autowired
//  AuthenticationProvider authenticationProvider;

    @Override
    public void authenticate(UserBean userBean, HttpServletRequest request) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userBean.getUsername(), userBean.getPassword());
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authentication = authenticationManager.authenticate(token);
//        Authentication authentication = authenticationProvider.authenticate(token);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

//    if(authentication.isAuthenticated())
//      SecurityContextHolder.getContext().setAuthentication(authentication);

//    SecurityContext sc = new SecurityContextImpl();
//    sc.setAuthentication(authentication);
//    SecurityContextHolder.setContext(sc);

    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logoutHandler.logout(request, response, authentication);
    }
}
