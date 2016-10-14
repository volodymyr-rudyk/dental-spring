
package com.dental.service.impl;

import com.dental.persistence.entity.FeedbackEntity;
import com.dental.persistence.repository.FeedbackRepository;
import com.dental.service.FeedbackService;
import com.dental.web.dto.FeedbackDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by light on 10/14/2016.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

  @Autowired
  private FeedbackRepository feedbackRepository;

  @Override
  public FeedbackEntity addFeedback(FeedbackDTO feedbackDTO) {
    FeedbackEntity feedbackEntity = new FeedbackEntity();
    feedbackEntity.setEmail(feedbackDTO.getEmail());
    feedbackEntity.setFeedback(feedbackDTO.getFeedback());
    return feedbackRepository.save(feedbackEntity);
  }

  @Override
  public FeedbackEntity find(Long id) {
    return feedbackRepository.findOne(id);
  }

  @Override
  public List<FeedbackEntity> findAll() {
    return (List<FeedbackEntity>) feedbackRepository.findAll();
  }
}
