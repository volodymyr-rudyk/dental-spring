package com.dental.persistence.repository;

import com.dental.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by light on 3/28/2015.
 */

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
  UserEntity findByEmail(String email);
}
