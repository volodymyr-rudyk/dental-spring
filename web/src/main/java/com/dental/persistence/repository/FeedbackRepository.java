package com.dental.persistence.repository;

import com.dental.persistence.entity.FeedbackEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vrudyk on 10/14/2016.
 */
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Long> {
}
