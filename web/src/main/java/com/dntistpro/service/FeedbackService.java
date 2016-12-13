package com.dntistpro.service;

import com.dntistpro.persistence.entity.FeedbackEntity;
import com.dntistpro.web.dto.FeedbackDTO;

import java.util.List;

/**
 * Created by light on 10/14/2015.
 */
public interface FeedbackService {

  FeedbackEntity addFeedback(FeedbackDTO feedback);

  FeedbackEntity find(Long id);

  List<FeedbackEntity> findAll();

}
