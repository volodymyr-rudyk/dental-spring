package com.dental.web.rest;

import com.dental.exception.NotFoundException;
import com.dental.helper.search.SearchStrategy;
import com.dental.helper.search.SearchStrategyFactory;
import com.dental.persistence.entity.PatientEntity;
import com.dental.service.DentistService;
import com.dental.service.SearchService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.PatientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * Created by vrudyk on 11/4/2015.
 */
@RestController
class SearchRestController extends BaseRestController {

  private static final Logger LOG = LoggerFactory.getLogger(SearchRestController.class);

  @Autowired
  private DentistService dentistService;

  @Autowired
  private SearchService searchService;

  @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST},
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> search(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam("q") String query, ModelMap model) throws NotFoundException {
    LOG.info("query = " + query);
    SearchStrategy searchStrategy = SearchStrategyFactory.getSearchStrategy(query, searchService);
    List<PatientEntity> patientEntities = searchStrategy.invoke();
    Set<PatientDTO> patientDTOs = DTOUtils.convert(patientEntities);
    LOG.info(String.valueOf("search = " + patientEntities.size()));
    return new ResponseEntity<>(patientDTOs, HttpStatus.OK);
  }

}
