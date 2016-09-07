package com.dental.service.impl;

import com.dental.persistence.entity.User;
import com.dental.persistence.repository.UserRepository;
import com.dental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vrudyk on 9/7/2016.
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void resetPassword(User user, String password) {
    user.setPassword(password);
    userRepository.save(user);
  }
}
