package com.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.beans.Employee;
import com.service.EmployeeService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private EmployeeService employeeService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println(this.getClass() + " Action执行之后");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println(this.getClass() + " 该方法在Action执行之后，视图生成之前");
	}

	/**
	 * 在Action执行之前检验Session是否存在
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println(this.getClass() + " Action执行之前");

		// 取得请求相关的ActionContext实例
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");

		// 从数据库查询所有的Employee对象
		List<Employee> empList = employeeService.getAll();
		System.out.println(this.getClass() + "dbEmp " + empList);

		if (employee != null) {

			return true;
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
		return false;
	}
}
