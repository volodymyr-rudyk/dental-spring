package com.dental.controllers;

import com.dental.dao.entity.User;
import com.dental.service.UserService;
import me.qq.Rt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by light on 1/1/2015.
 */

@Controller
public class WelcomeController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(HttpServletRequest request, HttpServletResponse response) {

        String data = Rt.DATA;
        String m1 = messageSource.getMessage("u", null, Locale.getDefault());
        String m2 = messageSource.getMessage("u", null, Locale.ENGLISH);

        User user = new User("test", "42424");
        userService.save(user);
        return "Hello world" + data + "  " + m1 + "  " + m2 + " Rt=" + data;
//        return "hello";
    }


    @RequestMapping(value = "/hello2")
    public String hello2(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         User user) {
//        String data = Rt.DATA;
        String m1 = messageSource.getMessage("u", null, Locale.getDefault());
        String m2 = messageSource.getMessage("u", null, Locale.ENGLISH);

        //optional.ifPresent(user -> System.out.println(user.getName() + " : " + user.getPhone()));
//        String s = null;
//        s.toString();
//        optional.get().getName();
        model.put("hello", 123);
        model.put("user", user);
        return "hello";
    }


    @ExceptionHandler(NullPointerException.class)
    public String handlerNPE(NullPointerException ex) {
        String message = ex.getMessage();
        System.out.println("HANDLER = " + message);

        return message;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        final CustomDateEditor dateEditor = new CustomDateEditor(df, true) {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if ("today".equals(text)) {
                    setValue(new Date());
                } else {
                    super.setAsText(text);
                }
            }
        };
        binder.registerCustomEditor(Date.class, dateEditor);
    }

}
