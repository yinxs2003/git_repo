package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Biz.UserBiz;
import com.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private UserBiz userBiz = new UserBiz();
	// private ArrayList<User> list = userBiz.getAll();
	private String userSessionKey = null;
	private final String ERROR_AUTHORITY_DENY = "输入的用户名密码有误！";

	/**
	 * 获取web.xml中配置名为userSessionKey的参数
	 */
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletConfig().getServletContext();
		userSessionKey = servletContext.getInitParameter("userSessionKey");
	}

	/**
	 * 直接处理session不存在的情况
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User userSession = (User) request.getSession().getAttribute("user");
		boolean flag = false;
		if (userSession == null) {// no session check
			flag = noSessionCheck(request, response);
		} else {// session check
			flag = sessionCheck(request, response, userSession);
		}
		if (!flag) {
			// 登录不成功，则跳转到login.jsp并提示登录不成功
			printErrorMsg(request, response, ERROR_AUTHORITY_DENY);
		}
	}

	public boolean sessionCheck(HttpServletRequest request, HttpServletResponse response, User userSession)
			throws IOException {
		boolean flag = false;
		// System.out.println("session:" + userSession.getUserName() + " " +
		// userSession.getPassWord());
		UserBiz userBiz = new UserBiz();
		List<User> list = userBiz.getAll();

		for (User user : list) {
			// 根据用户名获取用户
			if (user.getUserName().equals(userSession.getUserName())
					&& user.getPassWord().equals(userSession.getPassWord())) {
				int power = user.getPower();
				// power 1超市管理员，2供应商，3普通用户
				if (power == 1) {
					response.sendRedirect("QueryAdminServlet");
					flag = true;
				} else if (power == 2) {
					response.sendRedirect("providerAdmin.jsp");
					flag = true;
				} else if (power == 3) {
					response.sendRedirect("userAdmin.jsp");
					flag = true;
				}
			}
		}
		return flag;
	}

	/**
	 * 检测用户名密码是否正确
	 * 
	 * @param request
	 * @param response
	 * @param uname
	 * @param pwd
	 * @throws IOException
	 */
	public boolean noSessionCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean flag = false;
		// System.out.println("here");
		// 根据用户名获取用户
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		System.out.println("从网页获取的用户名密码是：" + userName + " " + passWord);
		// 登录成功则设置session
		// request.getSession().setAttribute("user", new User(userName,
		// passWord));
		UserBiz userBiz = new UserBiz();
		List<User> list = userBiz.getAll();

		for (User user : list) {
			// 根据用户名获取用户
			if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
				String userId = user.getUserId();
				int power = user.getPower();
				String powerName = user.getPowerName();
				User sessionUser = new User(userId, userName, passWord, power, powerName);
				request.getSession().setAttribute("user", sessionUser);
				// power 1超市管理员，2供应商，3普通用户
				if (power == 1 || power == 0) {
					response.sendRedirect("QueryAdminServlet");
					flag = true;
				} else if (power == 2) {
					response.sendRedirect("QueryAdminServlet");
					flag = true;
				}
			}
		}
		return flag;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 请重新输入用户名和密码
	 * 
	 * @param response
	 * @throws IOException
	 */
	public void printErrorMsg(HttpServletRequest request, HttpServletResponse response, String message)
			throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("登录失败，此时需清除session");
		HttpSession session = request.getSession(false);// 防止创建Session
		session.removeAttribute(userSessionKey);
		out.println("<script>");
		out.println("alert('" + message + "')");
		out.println("location.href='login.jsp'");
		out.println("</script>");
	}
}
