package com.dntistpro.persistence.repository;

import com.dntistpro.persistence.entity.ToothCureEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vrudyk on 7/3/2016.
 */

@Repository
public interface ToothCureRepository extends CrudRepository<ToothCureEntity, Long> {

  ToothCureEntity findById(Long id);

  ToothCureEntity findByIdAndToothId(Long id, Long toothId);

  Long countByDentistId(Long dentistId);

}
