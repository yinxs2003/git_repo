package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biz.ProviderBiz;
import com.entity.Bill;
import com.entity.Provider;
import com.util.ToolsUtil;

@WebServlet("/ProviderInitServlet")
public class ProviderInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProviderBiz providerBiz = new ProviderBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setProviderList(request);
		setBill(request);
		// System.out.println("hrehre");
		ToolsUtil.refreshPage("admin_update_index.jsp", request, response);
	}

	private void setBill(HttpServletRequest request) {
		String billId = request.getParameter("billId");
		String commodityName = request.getParameter("commodityName");
		String s_commodityQuantity = request.getParameter("commodityQuantity");
		int commodityQuantity = 0;
		if (s_commodityQuantity != null) {
			commodityQuantity = Integer.parseInt(s_commodityQuantity);
		}
		String commodityUtil = request.getParameter("commodityUnit");
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
		Bill bill = new Bill(billId, commodityName, commodityQuantity, commodityUtil, sumPrice, havePay, providerId,
				commodityDesc);
		System.out.println("before:" + providerId);
		request.getSession().setAttribute("bill", bill);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void setProviderList(HttpServletRequest request) {
		List<Provider> before_providerList = providerBiz.getAll();
		request.getSession().setAttribute("before_providerList", before_providerList);
	}

}
