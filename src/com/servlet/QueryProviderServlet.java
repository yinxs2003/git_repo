package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Biz.ProviderBiz;
import com.entity.Provider;

@WebServlet("/QueryProviderServlet")
public class QueryProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProviderBiz providerBiz = new ProviderBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		searchByCondition(request, response);
		putValueBack(request, response);
		refreshPage(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void searchByCondition(HttpServletRequest request, HttpServletResponse response) {
		// Page page = providerBiz.getPageCount();
		// System.out.println("page.getCount()"+page.getCount());
		String providerName = request.getParameter("providerName");
		// System.out.println("ProviderName"+providerName);
		if (providerName == null) {
			providerName = "";
		}
		String providerDesc = request.getParameter("providerDesc");
		if (providerDesc == null) {
			providerDesc = "";
		}
		List<Provider> providerList = null;
		String s_pageNow = request.getParameter("pageNow");
		int pageNow = 1;
		if (s_pageNow != null) {
			pageNow = Integer.parseInt(s_pageNow);
		}

		providerList = providerBiz.searchByCondition(providerName, providerDesc, pageNow);
		request.getSession().setAttribute("providerList", providerList);
		request.getSession().setAttribute("pageCount", providerBiz.getPageCount());
	}

	private void refreshPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		// String pageNow = request.getParameter("pageNow");
		// String havePay = request.getParameter("havePay");
		out.println("<script>");
		out.println("window.parent.window.location.href='providerIndex.jsp'");
		out.println("</script>");
		out.close();
	}

	private void putValueBack(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String providerName = null;
		String providerDesc = null;
		providerName = request.getParameter("providerName");
		providerDesc = request.getParameter("providerDesc");

		HttpSession session = request.getSession();
		session.setAttribute("providerName", providerName);
		session.setAttribute("providerDesc", providerDesc);
	}

}
