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

  @Query(nativeQuery = true,
    value = "SELECT count(*) from dentist_patient dp RIGHT JOIN patient p on dp.patient_id = p.id RIGHT JOIN tooth t on p.id = t.patient_id RIGHT JOIN tooth_cure tc on t.id = tc.tooth_id where dp.dentist_id=?1")
  Long countCures(Long dentistId);

}
