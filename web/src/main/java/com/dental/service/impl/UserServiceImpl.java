package com.dental.service.impl;

import com.dental.exception.EntityNotFountException;
import com.dental.helper.ResponseMessages;
import com.dental.persistence.entity.LanguageEntity;
import com.dental.persistence.entity.UserEntity;
import com.dental.persistence.repository.LanguageRepository;
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

  @Autowired
  private LanguageRepository languageRepository;

  @Override
  public void resetPassword(UserEntity user, String password) {
    user.setPassword(password);
    userRepository.save(user);
  }

  @Override
  public void updateLanguage(UserEntity user, String languageCode) {
    LanguageEntity languageEntity = languageRepository.findOneByCode(languageCode);
    if (languageEntity == null) {
      throw new EntityNotFountException(ResponseMessages.INCORRECT_LANGUAGE_CODE);
    }
    user.setLanguage(languageEntity);
    userRepository.save(user);
  }
}
