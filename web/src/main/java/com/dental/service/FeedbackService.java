package com.dental.service;

import com.dental.persistence.entity.FeedbackEntity;
import com.dental.web.dto.FeedbackDTO;

import java.util.List;

/**
 * Created by light on 10/14/2015.
 */
public interface FeedbackService {

  FeedbackEntity addFeedback(FeedbackDTO feedback);

  FeedbackEntity find(Long id);

  List<FeedbackEntity> findAll();

}
