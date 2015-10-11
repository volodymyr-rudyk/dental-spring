package com.dental.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
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

//    @Override
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
        throw new BadCredentialsException("user name not found, bad credentials");
    }

//
// @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
