package com.dntistpro.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vrudyk on 11/4/2015.
 */
@RestController
@RequestMapping(value = "/rest/public")
public class PublicRestController implements Rest {

  private Logger logger = LoggerFactory.getLogger(BaseRestController.class);

}
