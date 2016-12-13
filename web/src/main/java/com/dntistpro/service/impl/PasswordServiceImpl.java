package com.dntistpro.service.impl;

import com.dntistpro.persistence.entity.ForgotPasswordEntity;
import com.dntistpro.persistence.entity.UserEntity;
import com.dntistpro.persistence.repository.ForgotPasswordRepository;
import com.dntistpro.persistence.repository.UserRepository;
import com.dntistpro.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by vrudyk on 9/7/2016.
 */
@Service
public class PasswordServiceImpl implements PasswordService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ForgotPasswordRepository forgotPasswordRepository;

  @Override
  @Transactional
  public Optional<ForgotPasswordEntity> createForgotPassword(String email) {

    Optional<UserEntity> userOptional = Optional.ofNullable(userRepository.findByEmail(email));

    if (userOptional.isPresent()) {
      ForgotPasswordEntity forgotPassword = new ForgotPasswordEntity();
      forgotPassword.setUser(userOptional.get());
      forgotPassword.setCreatedOn(new Date());
      forgotPassword.setForgotPasswordKey(UUID.randomUUID().toString());
      forgotPasswordRepository.save(forgotPassword);
      return Optional.of(forgotPassword);
    }
    return Optional.ofNullable(null);
  }

  @Override
  public void useForgotPassword(String forgotPasswordKey, String password) {
    Optional<ForgotPasswordEntity> forgotPasswordOptional = Optional.ofNullable(
      forgotPasswordRepository.findByForgotPasswordKey(forgotPasswordKey));

    forgotPasswordOptional.ifPresent(forgot -> {
      Optional<Date> dateOptional = Optional.ofNullable(forgot.getUsedOn());
      if (!dateOptional.isPresent()) {
        UserEntity user = forgot.getUser();
        user.setPassword(password);
        userRepository.save(user);
        forgot.setUsedOn(new Date());
        forgotPasswordRepository.save(forgot);
      }
    });
  }

}
