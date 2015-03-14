package com.dental.controllers;

import com.dental.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//*
/*Created by light on 3/14/2015.
*/

@Controller
@ControllerAdvice
public class AboutController extends BaseController {

    @RequestMapping(value = "/about")
    public String about(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = false) String name ) throws NotFoundException {

        if (name != null) {
            throw new NotFoundException("URL : /about");
        }
        return "/about/about";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "404";
    }
}
