package com.dental.service;

import com.dental.dao.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by light on 3/28/2015.
 */
@Service
public class UserService {

    public User getUser() {
        return new User("User123", "123-1332-354");
    }
}
