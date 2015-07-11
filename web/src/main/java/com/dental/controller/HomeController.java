package com.dental.controller;

import com.dental.dao.component.UserDao;
import com.dental.dao.entity.User;
import com.dental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//*
/*Created by light on 3/14/2015.
*/

@Controller
//@ControllerAdvice
public class HomeController extends BaseController {

//    @Autowired
//    HibernateTransactionManager transactionManager;

    @Autowired
    protected UserDao userDao;

//    @Autowired
//    protected SessionFactory sessionFactory;

    @RequestMapping(value = "/")
    public String about(HttpServletRequest request, HttpServletResponse response, Model model) throws NotFoundException {


//        sessionFactory.getCurrentSession().save(profile);

//        user.setProfile(profile);
//        userDaoService.save(user);



//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

//        user.setProfile(profile);
//        userDao.save(user);
//        System.out.println(user.toString());
//        session.persist(user);
//        session.flush();
//        Profile o = (Profile) session.get(Profile.class, 15);

//        session.save(user);

//        session.getTransaction().commit();
//        session.close();

        //        userUserDaoService.get(1);

        List<User> list = userDao.getList();
        model.addAttribute("count",list.size());
        model.addAttribute("list",list);

        return "index";
    }

    @Override protected String getViewFolder() {
        return null;
    }

//    @ExceptionHandler(NotFoundException.class)
//    public String notFound() {
//        return "404";
//    }
}
