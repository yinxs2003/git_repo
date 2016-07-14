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

import com.Biz.BillBiz;
import com.entity.Bill;

@WebServlet("/QueryAdminServlet")
public class QueryAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillBiz billBiz = new BillBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		searchByCondition(request, response);
		putValueBack(request, response);
		refreshPage(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 回显功能
	 */
	private void putValueBack(HttpServletRequest request, HttpServletResponse response) {
		String havePay = request.getParameter("havePay");
		String productName = request.getParameter("productName");
		HttpSession session = request.getSession();
		System.out.println("have pay:" + havePay);
		System.out.println("product name:" + productName);
		session.setAttribute("havePay", havePay);
		session.setAttribute("productName", productName);
	}

	/**
	 * 条件分页查询
	 */
	private void searchByCondition(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String condition = request.getParameter("productName");
		if (condition == null) {
			condition = "";
		}
		String havePay = request.getParameter("havePay");
		List<Bill> billList = null;
		String s_pageNow = request.getParameter("pageNow");
		// System.out.println("s_pageNow" + s_pageNow);
		int pageNow = 1;
		if (s_pageNow != null) {
			pageNow = Integer.parseInt(s_pageNow);
		}
		billList = billBiz.searchByCondition(condition, havePay, pageNow);
		request.getSession().setAttribute("billList", billList);
		request.getSession().setAttribute("pageCount", billBiz.getPageCount());
		billBiz.resettConditionCount();
		// System.out.println("billList" + billList);
		// System.out.println(getPageCount());
	}

	/**
	 * 刷新父页面
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void refreshPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		// String pageNow = request.getParameter("pageNow");
		// String havePay = request.getParameter("havePay");
		out.println("<script>");
		out.println("window.parent.window.location.href='admin_index.jsp'");
		out.println("</script>");
		out.close();
	}
}
