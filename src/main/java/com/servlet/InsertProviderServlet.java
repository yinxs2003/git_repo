package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.ProviderBiz;

@WebServlet("/InsertProviderServlet")
public class InsertProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProviderBiz providerBiz = new ProviderBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count = 0;
		String providerId = request.getParameter("providerId");
		String providerName = request.getParameter("providerName");
		String providerDesc = request.getParameter("providerDesc");
		String providerMobile = request.getParameter("providerMobile");
		String providerAddress = request.getParameter("providerAddress");

		count = providerBiz.insert(providerId, providerName, providerDesc, providerMobile, providerAddress);
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
			out.println("window.parent.window.location.href='QueryProviderServlet'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('添加失败')");
			out.println("location.href='modify.jsp'");
			out.println("</script>");
		}
	}

}
