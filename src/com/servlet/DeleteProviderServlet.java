package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.ProviderBiz;
import com.util.ToolsUtil;

@WebServlet("/DeleteProviderServlet")
public class DeleteProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProviderBiz providerBiz = new ProviderBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String providerId = request.getParameter("providerId");
		int count = providerBiz.delete(providerId);
		ToolsUtil.showMessage(count, "QueryProviderServlet", "QueryProviderServlet", response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
