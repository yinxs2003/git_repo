package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.entity.User;
import com.mvc.service.UserService;

@Controller
@RequestMapping("mvc")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUser() {
		List<User> userList = userService.getAll();
		System.out.println(this.getClass() + " " + userList);
		return userList;
	 }

	@RequestMapping("/test")
	public String test(){
		System.out.println(this.getClass() + " test()");
		return "test";
	}
}
