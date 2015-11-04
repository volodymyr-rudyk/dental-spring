package com.dental.persistence.component;

import com.dental.persistence.entity.User;

/**
 * Created by light on 3/28/2015.
 */

public interface UserDao extends GenericCrud<User> {
  User loadUserByUserNameAndPassword(String userName, String password);

  User loadUserByLogin(String login);
}
