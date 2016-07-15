package com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToolsUtil {

	/**
	 * 操作成功或者失败的提示信息
	 * 
	 * @param count
	 *            受影响的行数
	 * @param successPageName
	 *            成功后跳转的页面
	 * @param failPageName
	 *            失败后跳转的页面
	 * @param response
	 * @throws IOException
	 */
	public static void showMessage(int count, String successPageName, String failPageName, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.println("<script>");
			out.println("alert('操作成功')");
			out.println("window.parent.window.location.href='" + successPageName + "'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('操作失败')");
			out.println("location.href='" + failPageName + "'");
			out.println("</script>");
		}

	}
	

	
	/**
	 * 使fremset的整个页面刷新
	 * 
	 * @param indexPage
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void refreshPage(String indexPage, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		// String pageNow = request.getParameter("pageNow");
		// String havePay = request.getParameter("havePay");
		out.println("<script>");
		out.println("window.parent.window.location.href='" + indexPage + "'");
		out.println("</script>");
		out.close();
	}

	/**
	 * 让freamset中的right跳转到指定页面
	 * 
	 * @param somePage
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void jumpToPage(String somePage, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		// String pageNow = request.getParameter("pageNow");
		// String havePay = request.getParameter("havePay");
		out.println("<script>");
		out.println("window.location.href='" + somePage + "'");
		out.println("</script>");
		out.close();
	}
}
