package com.dental.persistence.impl;

import com.dental.persistence.entity.User;
import com.dental.persistence.repository.AbstractRepository;
import com.dental.persistence.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by light on 4/5/2015.
 */
@Repository
@Transactional
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

  public UserRepositoryImpl() {
    super(User.class);
  }

  @Override
  public User loadUserByUserNameAndPassword(String email, String password) {
    String q = "select u from User u where u.email = :email and u.password = :password";
    Query namedQuery = entityManager.createQuery(q);
    namedQuery.setParameter("email", email);
    namedQuery.setParameter("password", password);
    namedQuery.setMaxResults(1);
    List resultList = namedQuery.getResultList();
    return resultList.size() > 0 ? (User) resultList.get(0) : null;
  }

  @Override
  public User loadUserByLogin(String email) {
    String q = "select u from User u where u.email = :email";
    Query namedQuery = entityManager.createQuery(q);
    namedQuery.setParameter("email", email);
    namedQuery.setMaxResults(1);
    List resultList = namedQuery.getResultList();
    return resultList.size() > 0 ? (User) resultList.get(0) : null;
  }

}
