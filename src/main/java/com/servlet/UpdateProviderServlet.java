package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.ProviderBiz;
import com.util.ToolsUtil;

@WebServlet("/UpdateProviderServlet")
public class UpdateProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProviderBiz providerBiz = new ProviderBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doUpdate(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String providerId = request.getParameter("providerId");
		String providerName = request.getParameter("providerName");
		String providerDesc = request.getParameter("providerDesc");
		String providerMobile = request.getParameter("providerMobile");
//		System.out.println(providerMobile);
		String providerAddress = request.getParameter("providerAddress");
		// Provider provider = new Provider(providerId, providerName,
		// providerDesc, providerMobile, providerAddress);
		// request.getSession().setAttribute("provider", provider);
		int count = providerBiz.update(providerId, providerName, providerDesc, providerMobile, providerAddress);
		ToolsUtil.showMessage(count, "QueryProviderServlet", "providerIndex.jsp", response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
