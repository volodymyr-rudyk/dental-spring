package com.dental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

/**
 * Created by light on 1/8/2015.
 */

//@Controller
public abstract class BaseController {

    @Autowired
    protected MessageSource messageSource;
}
