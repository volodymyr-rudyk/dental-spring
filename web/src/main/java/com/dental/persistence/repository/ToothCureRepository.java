package com.dental.persistence.repository;

import com.dental.persistence.entity.ToothCureEntity;
import org.springframework.data.jpa.repository.Query;
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
