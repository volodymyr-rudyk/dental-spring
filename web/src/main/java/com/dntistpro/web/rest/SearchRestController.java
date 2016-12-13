package com.dntistpro.web.rest;

import com.dntistpro.exception.NotFoundException;
import com.dntistpro.persistence.entity.PatientEntity;
import com.dntistpro.service.SearchService;
import com.dntistpro.web.dto.DTOUtils;
import com.dntistpro.web.dto.SearchPatientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by vrudyk on 11/4/2015.
 */
@RestController
class SearchRestController extends BaseRestController {

  private static final Logger LOG = LoggerFactory.getLogger(SearchRestController.class);

  @Autowired
  private SearchService searchService;

  @RequestMapping(value = "/search-patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> search(@RequestParam("q") String query) throws NotFoundException {
    List<PatientEntity> patientEntities = searchService.doSearch(query);
    Set<SearchPatientDTO> searchPatientDTOs = DTOUtils.convertSearch(patientEntities);
    LOG.info(String.valueOf("search = " + patientEntities.size()));
    return new ResponseEntity<>(searchPatientDTOs, HttpStatus.OK);
  }

}
