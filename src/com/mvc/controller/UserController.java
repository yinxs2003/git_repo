package com.mvc.controller;

import com.mvc.entity.User;
import com.mvc.service.UserService;
import com.mvc.util.MyHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.apache.log4j.Logger;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User loginUser = userService.findUserByUsername(username);
        if (loginUser != null && loginUser.getUsername().equals(username) && loginUser.getPassword().equals(password)) {
            MyHttpUtil.getSession().setAttribute("loginUser", loginUser);
            return "admin_index";
        }
        return "error";
    }

    @RequestMapping("/user/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    @ResponseBody
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
