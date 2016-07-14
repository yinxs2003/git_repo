package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.BillBiz;
import com.Biz.ProviderBiz;
import com.entity.Provider;
import com.util.ToolsUtil;

@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillBiz billBiz = new BillBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String billId = request.getParameter("billId");
		String commodityName = request.getParameter("commodityName");
		String s_commodityQuantity = request.getParameter("commodityQuantity");
		int commodityQuantity = 0;
		if (s_commodityQuantity != null) {
			commodityQuantity = Integer.parseInt(s_commodityQuantity);
		}
		String commodityUnit = request.getParameter("commodityUnit");
		System.out.println("update:"+commodityUnit);
		String s_sumPrice = request.getParameter("sumPrice");

		
		double sumPrice = 0;
		if (s_sumPrice != null) {
			sumPrice = Double.parseDouble(s_sumPrice);
		}

		String s_havePay = request.getParameter("havePay");
		int havePay = 0;
		if (s_havePay != null) {
			havePay = Integer.parseInt(s_havePay);
		}

		String providerId = request.getParameter("providerId");
		String commodityDesc = request.getParameter("commodityDesc");

		int count = billBiz.update(billId, commodityName, commodityQuantity, commodityUnit, sumPrice, havePay,
				providerId, commodityDesc);
		ToolsUtil.showMessage(count, "QueryAdminServlet", "modify.jsp", response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
