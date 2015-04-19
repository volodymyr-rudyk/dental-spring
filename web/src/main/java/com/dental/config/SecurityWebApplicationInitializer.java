package com.dental.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by admin on 07.04.2015.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    //loads springSecurityFilterChain
//    public SecurityWebApplicationInitializer() {
//        super(SpringSecureConfig.class);
//    }
}
