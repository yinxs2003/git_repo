<!-- 查看报销单 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String path = request.getContextPath();
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<s:debug></s:debug>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>

<!-- base需要放到head中 -->
<base href="<%=basePath%>" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function() {
		//日期选择控件
		$("#startDate").click(function() {
			WdatePicker({
				dateFmt : 'yyyy-MM-dd',
				maxDate : '#F{$dp.$D(\'endDate\')}',
				isShowClear : true,
				readOnly : true
			});
		});
		$("#endDate").click(function() {
			WdatePicker({
				dateFmt : 'yyyy-MM-dd',
				minDate : '#F{$dp.$D(\'startDate\')}',
				isShowClear : true,
				readOnly : true
			});
		});
	});
</script>
</head>
<body>
	<s:if
		test='#session.employee.postion.nameCn == "部门经理" || #session.employee.postion.nameCn == "总经理经理"||#session.employee.postion.nameCn == "财务"'>
		<a href="listClaimVoucher.action" target="_self">报销单管理</a>
	</s:if>

	<div class="top">
		<div class="global-width">
			<img src="images/logo.gif" class="logo" />
		</div>
	</div>

	<div class="status">
		<div class="global-width">
			<span class="usertype">【登录角色：${sessionScope.employee_position}】</span>${sessionScope.employee.name}
			${sessionScope.employee.postion.nameCn } 你好！欢迎访问青鸟办公管理系统！
			<a href="loginOut.action">
				<span>注销</span>
			</a>
		</div>
	</div>

	<div class="main">
		<div class="global-width">
			<div class="search">
				<!-- 				<form name="listSearch" method="post" action="">
					选择查询的日期：<input type="text" class="keywords" /> <input
						type="submit" value="提交查询" class="sub-search" />
				</form>
 -->

			</div>

			<!-- 左边导航栏 -->
			<jsp:include page="/jsp/common/indexSidebar.jsp" />

			<!-- 查询报销单显示的列表 -->
			<div class="action">
				<div class="t">报销单列表</div>
				<div class="pages">
					<!-- 导入searchBar.jsp -->
					<jsp:include page="/jsp/claim/searchBar.jsp"></jsp:include>
					<hr class="yin_color1" />

					<!--报销单列表 区域 开始-->
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list">
						<tr>
							<td>编号</td>
							<td>填报日期</td>
							<td>填报人</td>
							<td>总金额</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						<s:iterator value="#session.pager.claimVoucherList" var="claimVoucher">
							<tr>
								<td><s:property value="#claimVoucher.id" /></td>
								<td><s:date name="#claimVoucher.createTime" format="yyyy-MM-dd hh:mm" /></td>
								<td><s:property value="#claimVoucher.creator.name" /></td>
								<td>￥  <s:property value="#claimVoucher.totalAccount" />
								</td>
								<td><s:property value="#claimVoucher.status" /></td>
								<td><s:property value="" /> <s:if
										test="#claimVoucher.creator.sn == #session.employee.sn and (#claimVoucher.status == '新创建' or #claimVoucher.status == '已打回')">
										<%-- 编辑功能 --%>
										<a href="editClaimVoucher.action?id=<s:property value="#claimVoucher.id" />">
											<img src="images/edit.gif" width="16" height="16" alt="编辑报销单" />
										</a>
									</s:if> <s:if test="#claimVoucher.creator.sn == #session.employee.sn and #claimVoucher.status == '新创建'">
										<%-- 删除功能 --%>
										<a href="deleteClaimVoucher.action?id=<s:property value="#claimVoucher.id" />">
											<img src="images/delete.gif" width="16" height="16" alt="删除报销单" />
										</a>
									</s:if> <!--   <img src="images/save.gif" width="16" height="16" /> --> 
									<s:if test="#claimVoucher.status != '新创建'">
										<%-- 查看报销单功能 --%>
										<a href="viewClaimVoucher.action?id=<s:property value="#claimVoucher.id" />">
											<img src="images/search.gif" width="16" height="15" alt="查看报销单" />
										</a>
									</s:if> <!-- #claimVoucher.nextEmployee.sn == #session.employee.sn and (#claimVoucher.status == '已提交' or #claimVoucher.status == '已审批') -->
									<s:if test="#claimVoucher.nextEmployee.sn == #session.employee.sn">
										<%-- 审批报销单功能 --%>
										<a href="checkClaimVoucher.action?id=<s:property value="#claimVoucher.id" />">
											<img src="images/sub.gif" width="16" height="16" alt="审核报销单" />
										</a>
									</s:if></td>
							</tr>
						</s:iterator>
						<!-- 分页 -->
						<tr>
							<td colspan="6" align="center"><a href="searchByPaging?currentPage=1">首页</a> <%-- <s:if
									test="showClaimVoucher?pager.currentPage gt 6 ">
									<a href="#">前5页</a>
								</s:if> --%> <!-- value指的是List集合,idx代指value集合中的内容--> <%-- <s:iterator value="#session.pager.pageList" var="pageNo"> --%> <s:iterator
									value="#session.pager.pageList" var="pageNo">
									<s:if test="#pageNo != #session.pager.currentPage">
										<a href="searchByPaging?currentPage=<s:property value="#pageNo" />">
											<s:property value="#pageNo" />
										</a>
									</s:if>
									<s:else>
										<s:property value="#pageNo" />
									</s:else>
									<%-- <s:if test="#pageNo != #session.pager.currentPage">
										<a href="showClaimVoucher.action?pager.currentPage=<s:property value="#pageNo" />">
											<s:property value="#pageNo" />
										</a>
									</s:if>
									<s:else>
										<s:property value="#pageNo" />
									</s:else> --%>
								</s:iterator> <%-- <s:if test="#session.pager.currentPage lt (pager.totalPage - 4)">
									<a href="#">后5页</a> 
								</s:if>--%> <a href="searchByPaging?currentPage=<s:property value="#session.pager.totalPage" />">尾页</a></td>

						</tr>
					</table>
					<!--报销单列表 区域 结束-->
				</div>
			</div>
		</div>
	</div>

	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>
<s:property value="#employee.sn" />
</body>
</html>