package com.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.ClaimVoucher;
import com.beans.Employee;
import com.beans.Pager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.service.ClaimVoucherService;
import com.service.EmployeeService;

/**
 * 显示个人信息
 */
@Controller
@Scope("prototype")
public class ClaimVoucherAction {

	@Autowired
	private ClaimVoucherService claimVoucherService;
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 对应claim_voucher_search.jsp的查询条件
	 */
	private Map<String, Object> statusMap;
	private String status;// 报销单状态
	private Date startDate;// 开始日期
	private Date endDate;// 结束日期
	private Integer currentPage;// 接受来自分页的页数

	/**
	 * 添加报销单，对应于claim_voucher_add.jsp
	 */
	// 申请报销单的员工
	private java.sql.Date addDate;
	// 新报销单
	private Double totalAccount;
	// 报销单创建者
	private Employee employee;

	private Map<String, Object> getSessionMap() {
		// 获取上下文
		ActionContext ctx = ActionContext.getContext();
		// 获取session对象
		Map<String, Object> session = ctx.getSession();
		return session;
	}

	/**
	 * 查询报销单
	 * 
	 * @return 返回报销单的集合
	 */
	public String showClaimVoucher() {
		List<ClaimVoucher> claimVoucherList = claimVoucherService.getAll();
		System.err.println(this.getClass() + "show Claim Voucher");
		System.err.println(this.getClass() + " show claim voucher " + claimVoucherList);

		// 查询所有
		Pager pager = claimVoucherService.getByDetachedCriteria(null, 1);
		getSessionMap().put("pager", pager);
		return Action.SUCCESS;
	}

	/**
	 * 按照页数查询
	 * 
	 * @return
	 */
	public String searchByPaging() {
		System.err.println(this.getClass() + " searchByPaging " + currentPage);

		// 这里
		statusMap = new HashMap<String, Object>();
		statusMap.put("status", status);
		statusMap.put("startDate", startDate);
		statusMap.put("endDate", endDate);

		Pager pager = claimVoucherService.searchByPaging(statusMap, currentPage);
		getSessionMap().put("pager", pager);

		// System.out.println(pager.getClaimVoucherList());
		return Action.SUCCESS;
	}

	public String showClaimVoucherByCondition() {

		System.out.println(this.getClass() + " status " + status);
		System.out.println(this.getClass() + " startDate " + startDate);
		System.out.println(this.getClass() + " endDate " + endDate);

		// 根据条件查询

		// 设置statusMap的值
		statusMap = new HashMap<String, Object>();
		statusMap.put("status", status);
		statusMap.put("startDate", startDate);
		statusMap.put("endDate", endDate);

		System.err.println(this.getClass() + " showClaimVoucherByCondition");

		int currentPage = 1;
		Pager pager = claimVoucherService.getByDetachedCriteria(statusMap, currentPage);
		getSessionMap().put("pager", pager);
		return Action.SUCCESS;
	}

	/**
	 * 添加报销单,对应claim_voucher_search.jsp中的分页区域
	 */
	public String addClaimVoucher() {
		// 获取当前员工信息,sn,password
		System.out.println(this.getClass() + " add Claim Voucher add date" + addDate + " totalAccount " + totalAccount);
		String sn = employee.getSn();
		// 根据sn查询员工（Employee）的信息
		Employee creator = employeeService.getEmployeeBySn(sn);
		Employee nextDealer = new Employee();
		nextDealer.setSn(sn);

		ClaimVoucher newClaimVoucher = new ClaimVoucher(nextDealer, creator, addDate, addDate, "花费", totalAccount,
				"新创建");
		claimVoucherService.insert(newClaimVoucher);
		System.err.println(this.getClass() + " addClaimVoucher 被调用次数计数");
		return Action.SUCCESS;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, Object> getStatusMap() {
		return statusMap;
	}

	public void setStatusMap(Map<String, Object> statusMap) {
		this.statusMap = statusMap;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public java.sql.Date getAddDate() {
		return addDate;
	}

	public void setAddDate(java.sql.Date addDate) {
		this.addDate = addDate;
	}

	public Double getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(Double totalAccount) {
		this.totalAccount = totalAccount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}