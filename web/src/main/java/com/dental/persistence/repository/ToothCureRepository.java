package com.dental.persistence.repository;

import com.dental.persistence.entity.ToothCure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vrudyk on 7/3/2016.
 */

@Repository
public interface ToothCureRepository extends CrudRepository<ToothCure, Long> {

  ToothCure findById(Long id);

  ToothCure findByIdAndToothId(Long id, Long toothId);

}
