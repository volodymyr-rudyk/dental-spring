package com.dental.persistence.repository;

import com.dental.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vrudyk on 9/28/2016.
 */
@org.springframework.stereotype.Repository
public interface SearchRepository extends Repository<PatientEntity, Long> {

  @Query(value = "SELECT p.* from patient p LEFT JOIN dentist_patient dp on p.id = dp.patient_id where dp.dentist_id=:dentistId and p.first_name like :firstName", nativeQuery = true)
  List<PatientEntity> findByDentistAndFirstNameLike(@Param("dentistId") Long dentistId, @Param("firstName") String firstName);

  @Query(value = "SELECT p.* from patient p LEFT JOIN dentist_patient dp on p.id = dp.patient_id where dp.dentist_id=:dentistId and p.middle_name like :middleName", nativeQuery = true)
  List<PatientEntity> findByDentistsAndMiddleNameLike(@Param("dentistId") Long dentistId, @Param("middleName") String middleName);

  @Query(value = "SELECT p.* from patient p LEFT JOIN dentist_patient dp on p.id = dp.patient_id where dp.dentist_id=:dentistId and p.last_name like :lastName", nativeQuery = true)
  List<PatientEntity> findByDentistsAndLastNameLike(@Param("dentistId") Long dentistId, @Param("lastName") String lastName);

  @Query(value = "SELECT p.* from patient p LEFT JOIN dentist_patient dp on p.id = dp.patient_id where dp.dentist_id=:dentistId and p.first_name like :firstName  or p.first_name like :lastName or p.last_name like :firstName  or p.last_name like :lastName ", nativeQuery = true)
  List<PatientEntity> findByDentistsAndFirstNameLikeOrLastNameLike(@Param("dentistId") Long dentistId, @Param("firstName") String firstName, @Param("lastName") String lastName);

}
