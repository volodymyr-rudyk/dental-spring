package com.dental.service.impl;

import com.dental.dao.component.UserDao;
import com.dental.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 06.04.2015.
 */
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserDao<User> userDao;

    private static SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
    private static SimpleGrantedAuthority roleUser = new SimpleGrantedAuthority("ROLE_USER");

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userDao.loadUserByUserNameAndPassword(username, "");
        if(user == null)
          throw new UsernameNotFoundException("user name not found" + username);

        return new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> grantedAuthorityList = new LinkedList<SimpleGrantedAuthority>();

                grantedAuthorityList.add(roleAdmin);
                grantedAuthorityList.add(roleUser);
                return grantedAuthorityList;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getLogin();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}