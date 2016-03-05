package com.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.Employee;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.service.EmployeeService;

@Controller
@Scope("prototype")
public class LoginAction {// 这个类用来验证登录信息
	@Autowired
	@Qualifier("employee")
	private Employee employee;// struts自动获取employees

	@Autowired
	private EmployeeService employeeService;

	public String login() {
		String sn = employee.getSn();
		String password = employee.getPassword();

		System.out.println(this.getClass() + " sn: " + sn + " password " + password);

		// 根据sn从数据库读取数据，并包装成Employee对象
		Employee employee = employeeService.getEmployeeBySn(sn);

		// 获取上下文
		ActionContext ctx = ActionContext.getContext();
		// 获取session对象
		Map<String, Object> session = ctx.getSession();

		System.out.println(this.getClass() + " " + employee);
		if (employee != null) {
			String pwd = employee.getPassword();
			System.out.println(this.getClass() + " postion cnName " + employee.getPostion().getNameCn());
			if (pwd.equals(password)) {// 登录成功则将emp放入session
				System.out.println("login success");
				// 登录成功则保存当前session，并跳转到相应页面
				session.put("employee", employee);
				return Action.SUCCESS;
			}
		} else {// 不存在sn为主键的值，返回登录界面
			System.out.println("login failed");
			return Action.INPUT;
		}
		return null;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
