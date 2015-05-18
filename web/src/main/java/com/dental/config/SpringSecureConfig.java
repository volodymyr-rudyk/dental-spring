package com.dental.config;

//import com.dental.provider.DentalAuthenticationProvider;
//import com.dental.service.impl.UserDetailsServiceImpl;

import com.dental.provider.DentalAuthenticationProvider;
import com.dental.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 * Created by admin on 06.04.2015.
 */
@EnableWebSecurity
@Configuration
public class SpringSecureConfig extends WebSecurityConfigurerAdapter {

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
                //Configures form login
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .failureUrl("/login?error=bad_credentials")
                        //Configures the logout function
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                        //Configures url based authorization
                .and()
                .authorizeRequests()
                        //Anyone can access the urls
                .antMatchers(
                        "/auth/**",
                        "/",
                        "/login",
                        "/authenticate",
                        "/signup/**",
                        "/logout",
                        "/user/register/**"
                ).permitAll()
                //The rest of the our application is protected.
                .antMatchers("/**").hasRole("USER");
        //Adds the SocialAuthenticationFilter to Spring Security's filter chain.


    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/authenticate")
                .antMatchers("/logout")
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/font/**")
                .antMatchers("/img/**");
    }

    @Bean(name = "dentalAuthenticationManager")
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // in-memory auth
//        auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");

        // Dao auth
//        auth.userDetailsService(new UserDetailsServiceImpl());

        auth.authenticationProvider(getAuthenticationProvider());
//    }

//    @Bean
//    public RoleVoter getRoleVoter() {
//        RoleVoter roleVoter = new RoleVoter();
//        roleVoter.setRolePrefix("ROLE_");
//        return roleVoter;
    }

    //region User Details related functionality
    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsServiceImpl();
    }

    //endregion
//
    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(new UserDetailsServiceImpl());
//        return daoAuthenticationProvider;
        return new DentalAuthenticationProvider();
    }

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
}
