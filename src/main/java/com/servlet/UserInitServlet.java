package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.UserBiz;
import com.entity.User;
import com.util.ToolsUtil;

@WebServlet("/UserInitServlet")
public class UserInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private ProviderBiz providerBiz = new ProviderBiz();
	private UserBiz userBiz = new UserBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setUser(request);
		ToolsUtil.refreshPage("userModifyIndex.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void setUser(HttpServletRequest request) {
		List<User> before_userList = userBiz.getAll();
		String userId = request.getParameter("userId");
		User before_user = null;
		for (User user : before_userList) {
			if (user.getUserId().equals(userId)) {
				before_user = user;
				break;
			}
		}
		request.getSession().setAttribute("before_user", before_user);
	}

}
