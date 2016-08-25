package com.mvc.controller;

import com.mvc.entity.User;
import com.mvc.service.UserService;
import com.mvc.util.MyHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//import org.apache.log4j.Logger;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

//    private HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User loginUser = userService.findUserByUsername(username);
        if (loginUser != null && loginUser.getUsername().equals(username) && loginUser.getPassword().equals(password)) {
            MyHttpUtil.getSession().setAttribute("loginUser", loginUser);
            return "admin_index";
        }
        return "error";
    }

    @RequestMapping(value = "/personManagement", method = RequestMethod.GET)
    public String personManagement() {
        User loginUser = (User) httpSession.getAttribute("loginUser");
        User localUser;
        if (loginUser != null) {
            localUser = userService.findUserByUsername(loginUser.getUsername());

            if (localUser != null && loginUser.getPassword().equals(localUser.getPassword())) {
                MyHttpUtil.getSession().setAttribute("loginUser", loginUser);
                return "admin_bill_list";
            }
        }
        System.out.println("------loginUser: " + loginUser + "--------");

        return "error";
    }


    @RequestMapping("/userManagement")
    public String userManagement(HttpServletRequest request) {
        List<User> userList = userService.findAll();
        request.setAttribute("userList",userList);
        return "user_admin";
    }

    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    @ResponseBody
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/userModify")
    public String userModify(@RequestParam String id){
        User user = userService.findUserById(id);

        return "user_admin";
    }
}
