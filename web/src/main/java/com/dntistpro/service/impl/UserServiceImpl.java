package com.dntistpro.service.impl;

import com.dntistpro.exception.EntityNotFountException;
import com.dntistpro.helper.ResponseMessages;
import com.dntistpro.persistence.entity.LanguageEntity;
import com.dntistpro.persistence.entity.UserEntity;
import com.dntistpro.persistence.repository.LanguageRepository;
import com.dntistpro.persistence.repository.UserRepository;
import com.dntistpro.service.UserService;
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
