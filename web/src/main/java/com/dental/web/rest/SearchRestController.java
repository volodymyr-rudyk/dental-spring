package com.dental.web.rest;

import com.dental.exception.NotFoundException;
import com.dental.persistence.entity.Dentist;
import com.dental.service.DentistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vrudyk on 11/4/2015.
 */
@RestController
class SearchRestController extends BaseRestController {

    private static final Logger LOG = LoggerFactory.getLogger(SearchRestController.class);

    @Autowired
    private DentistService dentistService;

    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST}
//          produces = "application/json",  consumes = "*/*"
    )
    public Dentist search(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam("q") String query, ModelMap model) throws NotFoundException {
      LOG.info("query = " + query);
      Dentist dentist = dentistService.get(1l);

//    return new ResponseEntity<>(profile, HttpStatus.OK);
      return dentist;
    }

}
