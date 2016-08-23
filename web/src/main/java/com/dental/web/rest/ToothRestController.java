package com.dental.web.rest;

import com.dental.bean.ToothCureRequestBean;
import com.dental.bean.ToothRequestBean;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Tooth;
import com.dental.persistence.entity.ToothCure;
import com.dental.service.AuthService;
import com.dental.service.ToothService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.ToothCureDTO;
import com.dental.web.dto.ToothDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by light on 4/7/2015.
 */
@RestController
public class ToothRestController extends BaseRestController {

  @Autowired
  protected AuthService authService;

  @Autowired
  private ToothService toothService;

  @RequestMapping(value = "/tooth", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ToothDTO> tooth(HttpServletRequest httpServletRequest, @LoggedDentist Dentist loggedDentist,
                                           ToothRequestBean toothRequestBean)  {
    Tooth tooth = toothService.get(toothRequestBean.getToothId(), toothRequestBean.getPatientId());
    ToothDTO toothDTO = DTOUtils.convert(tooth);
    ResponseEntity<ToothDTO> responseEntity = new ResponseEntity<>(toothDTO, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(value = "/tooth/cures", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ToothDTO> toothCures(HttpServletRequest httpServletRequest, @LoggedDentist Dentist loggedDentist,
                                             ToothRequestBean toothRequestBean)  {
    Tooth tooth = toothService.load(toothRequestBean.getToothId(), toothRequestBean.getPatientId());
    ToothDTO toothDTO = DTOUtils.convertDeep(tooth);
    ResponseEntity<ToothDTO> responseEntity = new ResponseEntity<>(toothDTO, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(value = "/tooth/cures", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ToothCureDTO> toothCuresPost(HttpServletRequest httpServletRequest, @LoggedDentist Dentist loggedDentist,
                                             @RequestBody ToothCureRequestBean toothCureRequestBean)  {
    ToothCure toothCure = new ToothCure(toothCureRequestBean.getCure());
    toothCure = toothService.addCure(toothCure, toothCureRequestBean.getToothId(), toothCureRequestBean.getPatientId());
    ToothCureDTO toothCureDTO = DTOUtils.convert(toothCure);
    return new ResponseEntity<>(toothCureDTO, HttpStatus.CREATED);
  }
}