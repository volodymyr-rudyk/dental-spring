package com.dental.persistence.repository;

import com.dental.persistence.entity.DentistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vrudyk on 27.05.2015.
 */
@Repository
public interface DentistRepository extends CrudRepository<DentistEntity, Long> {
}
