package com.dental.web.rest;

import com.dental.persistence.entity.DentistEntity;
import com.dental.service.DentistService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.DentistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * Created by light on 12/5/2015.
 */
@RestController
public class DentistPublicRestController extends PublicRestController {

  @Autowired
  private DentistService dentistService;

  @RequestMapping(value = "/dentists", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getPatients(HttpServletRequest httpServletRequest, @PageableDefault(size = 7) Pageable page) {
    List<DentistEntity> all = dentistService.findAll();
    Set<DentistDTO> dentistDTOs = DTOUtils.convert(all);
    return new ResponseEntity<>(dentistDTOs, HttpStatus.OK);
  }

  @RequestMapping(value = "/dentists/{id}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getPatient(@PathVariable("id") Long dentistId) {
    DentistEntity dentist = dentistService.findOne(dentistId);
    DentistDTO dentistDTO = DTOUtils.convertShort(dentist);
    return success(dentistDTO);
  }

}