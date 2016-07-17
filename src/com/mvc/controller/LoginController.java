package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mvc.entity.Customer;
import com.mvc.entity.User;
import com.mvc.service.CustomerService;

@RestController("sun")
public class LoginController {

	static final Logger logger = Logger.getLogger(LoginController.class);

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

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(@RequestParam("username") String name, @RequestParam("password") String pass) {
//		logger.info(this.getClass() + " " + "访问login");
//		User loginUser = customerService.getCustomerByName(name);
//		if (loginUser != null && loginUser.getName().equals(name) && loginUser.getPass().equals(pass)) {
//			getSession().setAttribute("loginUser", loginUser);
//			return "index";
//		}
		return "error";
	}

	@RequestMapping("/user/reg")
	public String reg(@RequestParam("username") String username, @RequestParam("password") String password) {
		logger.info("username: " + username + "password" + password);
		if (customerService.insert(new Customer(username, password))) {
			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping("/user/modify")
	public String modify(@RequestParam("username") String username, @RequestParam("password") String password) {
		logger.info("username: " + username + "password" + password);
		customerService.update(new Customer(username, password));
		return "success";
	}

}
