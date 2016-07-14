package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.BillBiz;

@WebServlet("/InsertAdminServlet")
public class InsertAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insert(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String billId = request.getParameter("billId");
		String commodityName = request.getParameter("commodityName");
		String s_price = request.getParameter("price");
		double price = 0;
		if (s_price != null) {
			price = Double.parseDouble(s_price);
		}
		String s_commodityQuantity = request.getParameter("commodityQuantity");
		int commodityQuantity = 0;
		if (s_commodityQuantity != null) {
			commodityQuantity = Integer.parseInt(s_commodityQuantity);
		}
		String commodityUnit = request.getParameter("unit");

		// String s_year = request.getParameter("sel_year");
		// String s_month = request.getParameter("sel_month");
		// String s_day = request.getParameter("sel_day");
		// String s_date = null;
		// if (s_year != null && s_month != null && s_day != null) {
		// s_date = s_year + "-" + s_month + "-" + s_day;
		// }

		String description = request.getParameter("description");
		String s_havePay = request.getParameter("havePay");
		int havePay = 0;
		if (s_havePay != null) {
			havePay = Integer.parseInt(s_havePay);
		}

		// 提供者的编号
		String s_supplierId = request.getParameter("supplierId");
		int supplierId = 0;
		if (s_supplierId != null) {
			supplierId = Integer.parseInt(s_supplierId);
		}
		BillBiz billBiz = new BillBiz();
		int count = billBiz.insert(billId, commodityName, commodityQuantity, commodityUnit, price, havePay, supplierId,
				description);
		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.println("<script>");
			out.println("alert('添加成功')");
			out.println("window.parent.window.location.href='QueryAdminServlet'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('添加失败')");
			out.println("location.href='modify.jsp'");
			out.println("</script>");
		}
	}

}
