package com.dental.persistence.repository;

import com.dental.persistence.entity.User;

/**
 * Created by light on 3/28/2015.
 */

public interface UserRepository extends GenericRepository<User> {
  User loadUserByUserNameAndPassword(String userName, String password);

  User loadUserByLogin(String login);
}
