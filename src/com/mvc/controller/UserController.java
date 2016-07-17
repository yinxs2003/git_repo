package com.mvc.controller;

import com.mvc.entity.User;
import com.mvc.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;

    public static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}
    
    public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}
    
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		logger.info(this.getClass() + " " + "访问login");
		User loginUser = userService.findUserByUsername(username);
		if (loginUser != null && loginUser.getUsername().equals(username) && loginUser.getPassword().equals(password)) {
			getSession().setAttribute("loginUser", loginUser);
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
