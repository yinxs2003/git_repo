package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Biz.UserBiz;
import com.entity.User;

@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserBiz userBiz = new UserBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("QueryUserServlet");
		searchByCondition(request, response);
		putValueBack(request, response);
		refreshPage(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void searchByCondition(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		if (userName == null) {
			userName = "";
		}

		List<User> userList = null;
		String s_pageNow = request.getParameter("pageNow");
		int pageNow = 1;
		if (s_pageNow != null) {
			pageNow = Integer.parseInt(s_pageNow);
		}

		userList = userBiz.searchByCondition(userName, pageNow);
		request.getSession().setAttribute("userList", userList);
		request.getSession().setAttribute("pageCount", userBiz.getPageCount());
	}

	private void refreshPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
//		out.println("window.parent.window.location.href='userIndex.jsp'");
		out.println("window.parent.window.location.href='userIndex.jsp'");
		out.println("</script>");
		out.close();
	}

	private void putValueBack(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
	}

}
