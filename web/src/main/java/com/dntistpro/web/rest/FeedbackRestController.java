package com.dntistpro.web.rest;

import com.dntistpro.service.FeedbackService;
import com.dntistpro.web.dto.FeedbackDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by light on 10/14/2016.
 */
@Controller
public class FeedbackRestController extends PublicRestController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackRestController.class);

  @Autowired
  private FeedbackService feedbackService;

  @RequestMapping(value = "/feedback", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity addFeedback(@RequestBody FeedbackDTO feedbackDTO) {
    feedbackService.addFeedback(feedbackDTO);
    LOGGER.info("Feedback added");
    return success();
  }

//  @RequestMapping(value = "feedback", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//  public ResponseEntity allFeedbacks() {
//    List<FeedbackEntity> all = feedbackService.findAll();
//    return success(all);
//  }

//  @RequestMapping(value = "feedback/{feedbackId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//  public ResponseEntity allFeedbacks() {
//
//  }

}
