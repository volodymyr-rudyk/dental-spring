package com.dental.controllers;

import me.qq.Rt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by light on 1/1/2015.
 */

@Controller
public class AController extends BaseController{



    @RequestMapping(value = "/a")
    @ResponseBody
    public String hello(HttpServletRequest request, HttpServletResponse response) {

        String data = Rt.DATA;
        String m1= messageSource.getMessage("u", null, Locale.getDefault());
        String m2= messageSource.getMessage("u", null, Locale.ENGLISH);

//        return "Hello world" + data + "  " + m1 + "  " + m2 + " Rt="+data;
        return "a controller";
    }

}
