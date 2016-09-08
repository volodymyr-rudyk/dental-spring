package com.dental.service.impl;

import com.dental.persistence.entity.ForgotPassword;
import com.dental.persistence.entity.User;
import com.dental.persistence.repository.ForgotPasswordRepository;
import com.dental.persistence.repository.UserRepository;
import com.dental.service.PasswordService;
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
  public Optional<ForgotPassword> createForgotPassword(String email) {

    Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));

    if (userOptional.isPresent()) {
      ForgotPassword forgotPassword = new ForgotPassword();
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
    Optional<ForgotPassword> forgotPasswordOptional = Optional.ofNullable(
      forgotPasswordRepository.findByForgotPasswordKey(forgotPasswordKey));

    forgotPasswordOptional.ifPresent(forgot -> {
      Optional<Date> dateOptional = Optional.ofNullable(forgot.getUsedOn());
      if (!dateOptional.isPresent()) {
        User user = forgot.getUser();
        user.setPassword(password);
        userRepository.save(user);
        forgot.setUsedOn(new Date());
        forgotPasswordRepository.save(forgot);
      }
    });
  }

}
