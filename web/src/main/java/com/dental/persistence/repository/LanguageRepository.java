package com.dental.persistence.repository;

import com.dental.persistence.entity.LanguageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by light on 3/28/2015.
 */

@Repository
public interface LanguageRepository extends CrudRepository<LanguageEntity, Long> {
  LanguageEntity findOneByCode(String code);
}
