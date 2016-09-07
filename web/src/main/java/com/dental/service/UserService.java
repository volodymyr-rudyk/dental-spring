package com.dental.service;

import com.dental.persistence.entity.User;

/**
 * Created by vrudyk on 9/7/2016.
 */
public interface UserService {
  void resetPassword(User user, String password);
}
