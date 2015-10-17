package com.dental.dao.component;

import com.dental.dao.entity.User;

/**
 * Created by light on 3/28/2015.
 */

public interface UserDao extends GenericCrud<User> {
  User loadUserByUserNameAndPassword(String userName, String password);

  User loadUserByLogin(String login);
}
