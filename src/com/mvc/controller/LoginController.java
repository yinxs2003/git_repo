package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mvc.entity.Customer;
import com.mvc.service.CustomerService;

@Controller("loginController")
public class LoginController {

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
		System.out.println(this.getClass() + " " + "访问login");
		Customer loginUser = customerService.getCustomerByName(name);
		if (loginUser != null && loginUser.getPass().equals(pass)) {
			getSession().setAttribute("loginUser", loginUser);

			return "index";
		}

		return "error";
	}

	@RequestMapping("/login")
	public String login() {
		System.out.println("跳转到index页面");
		return "index";
	}
}
