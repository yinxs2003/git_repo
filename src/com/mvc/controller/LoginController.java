package com.mvc.controller;

import com.mvc.entity.Customer;
import com.mvc.service.CustomerService;
//import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

//    static {
//        PropertyConfigurator.configure("log4j.xml");
//    }


    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        Customer loginUser = customerService.getCustomerByName(name);
        if (loginUser.getPass().equals(pass)) {

            getSession().setAttribute("loginUser", loginUser);

            return "index";
        }
        return "error";
    }
}
