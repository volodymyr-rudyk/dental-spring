package com.dental.controllers;

import com.dental.dao.entity.Profile;
import com.dental.dao.entity.User;
import com.dental.dao.service.UserDaoService;
import com.dental.exception.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


//*
/*Created by light on 3/14/2015.
*/

@Controller
@ControllerAdvice
public class HomeController extends BaseController {

    @Autowired
    protected UserDaoService<User> userDaoService;

    @Autowired
    protected SessionFactory sessionFactory;

    @RequestMapping(value = "/")
    public String about(HttpServletRequest request, HttpServletResponse response) throws NotFoundException {

        User user = new User();
        user.setName("Test" + new Date().toInstant().toString());
        user.setIsEnabled(true);
        Profile profile = new Profile();
        profile.setBirthday(new Date());
        profile.setFirstName("Profile first");
        profile.setLastName("Profile last");
        profile.setPhone("123-432-1");
        user.setProfile(profile);
        profile.setUser(user);

        userDaoService.save(user);


//        userUserDaoService.get(1);

        return "index";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "404";
    }
}
