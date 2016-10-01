package com.dental.service;

import com.dental.persistence.entity.UserEntity;

/**
 * Created by vrudyk on 9/7/2016.
 */
public interface UserService {
  void resetPassword(UserEntity user, String password);
  void updateLanguage(UserEntity user, String languageCode);
}
