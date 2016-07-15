package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {
	private String userSessionKey = null;
	private String redirectPage = null;
//	private String unCkeckedUrls = null;

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext servletContext = fConfig.getServletContext();
		userSessionKey = servletContext.getInitParameter("userSessionKey");
		redirectPage = servletContext.getInitParameter("redirectPage");
//		unCkeckedUrls = servletContext.getInitParameter("unCkeckedUrls");

		// System.out.println(userSessionKey);
		// System.out.println(redirectPage);
		// System.out.println(unCkeckedUrls);

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("LoginFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String path = req.getRequestURI();
		// System.out.println("path: " + path);
		if (path.indexOf("login.jsp") > -1 || path.indexOf("LoginServlet") > -1) {
			chain.doFilter(req, resp);
			return;
		}

		// 检测提交的请求是否为image路径下的文件，是，放行
		if (req.getRequestURI().indexOf("css") > -1 || req.getRequestURI().indexOf("image") > -1
				|| req.getRequestURI().indexOf("jquery.js") > -1) {
			// System.out.println("image文件夹下被放行");
			chain.doFilter(req, resp);
			return;
		}

		// 3.从session中获取sessionKey对应的值，若值不存在，则重定向到redirectPage
		Object obj = req.getSession().getAttribute(userSessionKey);
		if (obj == null) {
			// System.out.println("被重定向到redirectPage： " + redirectPage);
			resp.sendRedirect(redirectPage);
			return;
		} else {
			// 已经登陆,继续此次请求
			chain.doFilter(request, response);
			return;
		}
	}
}
