package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.UserBiz;
import com.util.ToolsUtil;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz = new UserBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doUpdate(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
//		String passWord = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String s_age = request.getParameter("age");
		int age = 0;
		if (s_age != null) {
			age = Integer.parseInt(s_age);
		}
		String phoneNumber = request.getParameter("phoneNumber");
		System.err.println("phone number :"+phoneNumber);
		String address = request.getParameter("address");
//		String power = request.getParameter("power");

//		int count = userBiz.update(userId, userName, passWord, sex, age, phoneNumber, address, power);
		int count = userBiz.update(userId,userName,sex,age,phoneNumber,address);
		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.println("<script>");
			out.println("alert('操作成功')");
			out.println("window.parent.window.location.href='QueryUserServlet'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('操作失败')");
			out.println("window.parent.window.location.href='userIndex.jsp'");
			out.println("</script>");
		}
//		ToolsUtil.showMessage(count, "QueryUserServlet", "wind", response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
