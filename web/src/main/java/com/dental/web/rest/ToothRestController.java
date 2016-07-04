package com.dental.web.rest;

import com.dental.bean.ToothRequestBean;
import com.dental.init.LoggedDentist;
import com.dental.persistence.entity.Dentist;
import com.dental.persistence.entity.Tooth;
import com.dental.service.AuthService;
import com.dental.service.ToothService;
import com.dental.web.dto.DTOUtils;
import com.dental.web.dto.ToothDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<ToothDTO> getTooth(HttpServletRequest httpServletRequest, @LoggedDentist Dentist loggedDentist,
                                           ToothRequestBean toothRequestBean)  {

    Tooth tooth = toothService.get(toothRequestBean.getToothId(), toothRequestBean.getPatientId());
    ToothDTO toothDTO = DTOUtils.convert(tooth);
    ResponseEntity<ToothDTO> responseEntity = new ResponseEntity<>(toothDTO, HttpStatus.OK);
    return responseEntity;
  }

}