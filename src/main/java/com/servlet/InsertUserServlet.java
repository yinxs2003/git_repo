package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.UserBiz;

@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz = new UserBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String s_age = request.getParameter("age");
		int age = 0;
		if (s_age != null) {
			age = Integer.parseInt(s_age);
		}
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String s_power = request.getParameter("power");
		int power = 0;
		if (s_power != null) {
			power = Integer.parseInt(s_power);
		}
		int count = userBiz.insert(userId, userName, password, sex, age, phoneNumber, address, power);
		showMsg(count, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showMsg(int count, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.println("<script>");
			out.println("alert('添加成功')");
			out.println("window.parent.window.location.href='QueryUserServlet'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('添加失败')");
			out.println("location.href='userAdd.jsp'");
			out.println("</script>");
		}
	}

}
