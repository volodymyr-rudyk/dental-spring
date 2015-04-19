package com.dental.service;

import org.apache.commons.logging.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by light on 4/18/2015.
 */
public class DentalAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println(authentication.getPrincipal() + " = " + authentication.getCredentials());

        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            if(userDetails.getPassword().equals(password)) {
                return new UsernamePasswordAuthenticationToken(userDetails,
                        userDetails.getPassword(), userDetails.getAuthorities());
            }
        }catch (UsernameNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        throw new RuntimeException("NOT");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
