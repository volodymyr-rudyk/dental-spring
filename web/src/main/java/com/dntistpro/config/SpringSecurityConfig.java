package com.dntistpro.config;

import com.dntistpro.oauth.jwt.StatelessAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by light on 06.04.2015.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  @Qualifier("tokenAuthenticationProvider")
  AuthenticationProvider tokenAuthenticationProvider;

  @Autowired
  @Qualifier("dentalAuthenticationProvider")
  AuthenticationProvider dentalAuthenticationProvider;

//  @Autowired
//  private AuthenticationProvider dentalAuthenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/login", "/authenticate").permitAll()
//                .antMatchers("/secure").hasRole("USER").and().
//
//        formLogin()
//                .loginPage("/login").loginProcessingUrl("/authenticate").failureUrl("/fail")
//                .and()
//                .logout().deleteCookies("JSESSIONID").logoutUrl("/logout").logoutSuccessUrl("/login");
//
////                .and()
//
    http
      .csrf().disable()
      .exceptionHandling().and()
      .anonymous().and()
      .servletApi().and()
      .headers().cacheControl()
      .and()
      .and().authorizeRequests()


//      .csrf().disable()
      //Configures form login
      //Configures the logout function
//        .logout()
//        .deleteCookies("JSESSIONID")
      //Configures url based authorization
//        .and()
//        .authorizeRequests()

      //Anyone can access the urls
      .antMatchers(
        "/rest/login",
        "/rest/signup",
        "/rest/forgot-password",
        "/rest/reset-password/*",
        "/rest/public/**",
        "/swagger-ui.html",
        "/v2/api-docs",
        "/configuration/ui",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**"
      ).permitAll()

      //The rest of the our application is protected.
//      .anyRequest().authenticated()
        .antMatchers("/**").hasRole("USER")
    //Adds the SocialAuthenticationFilter to Spring Security's filter chain.

// Custom Token based authentication based on the header previously given to the client
                .and()
      .addFilterAfter(statelessAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/v2/api-docs",
                                            "/configuration/ui",
                                            "/swagger-resources",
                                            "/swagger-resources/**",
                                            "/configuration/security",
                                            "/swagger-ui.html",
                                            "/webjars/**");
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManager() throws Exception {
    List<AuthenticationProvider> providers = new ArrayList<>();
    providers.add(tokenAuthenticationProvider);
    providers.add(dentalAuthenticationProvider);
    ProviderManager providerManager = new ProviderManager(providers);

    return providerManager;
//    return super.authenticationManager();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    // in-memory auth
//        auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");

    // Dao auth
//        auth.userDetailsService(userDetailsService());
//    AuthenticationProvider
//    auth..authenticationProvider(dentalAuthenticationProvider);
//    }

//    @Bean
//    public RoleVoter getRoleVoter() {
//        RoleVoter roleVoter = new RoleVoter();
//        roleVoter.setRolePrefix("ROLE_");
//        return roleVoter;
  }

//  @Bean
//  public AuthenticationProvider getAuthenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(new UserDetailsServiceImpl());
//        return daoAuthenticationProvider;
//    return new DentalAuthenticationProvider();
//  }

//    @Bean
//    public ProviderManager getProviderManager() {
//        List<AuthenticationProvider> authenticationProviders = new ArrayList<>();
//        authenticationProviders.add(getAuthenticationProvider());
//        return new ProviderManager(authenticationProviders);
//    }

//    @Bean
//    public SecurityContextPersistenceFilter getSecurityContextPersistenceFilter() {
//        return new SecurityContextPersistenceFilter();
//    }

  @Bean
  public LogoutHandler getLogoutHandler() {
    return new SecurityContextLogoutHandler();
  }

  @Bean
  public StatelessAuthenticationFilter statelessAuthenticationFilter() {
    return new StatelessAuthenticationFilter();
  }


}
