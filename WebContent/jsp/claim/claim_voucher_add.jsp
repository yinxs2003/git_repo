<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String images = request.getContextPath() + "/images";
	session.setAttribute("images", images);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function() {

		var mydate = new Date();
		var t = mydate.toLocaleString();

		//日期选择控件
		$("#addDate").click(function() {
			WdatePicker({
				dateFmt : 'yyyy-MM-dd',
				//maxDate : '#F{$dp.$D(\'endDate\')}',
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
	<s:debug></s:debug>
	<%-- <s:if test="%{#session.employee!=null}"> --%>
	<div class="top">
		<div class="global-width">
			<img src="images/logo.gif" class="logo" />
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			<span class="usertype">【登录角色：<s:property value="%{#session.employee.position.nameCn}" />】
			</span>
			<s:property value="%{#session.employee.name}" />
			你好！欢迎访问青鸟办公管理系统！
			<a href="loginOut.action">注销</a>
		</div>
	</div>
	<div class="main">
		<div class="global-width">
			
			<!-- 导入左侧导航 -->
			<jsp:include page="/jsp/common/indexSidebar.jsp" />
			<form action="addClaimVoucher" id="myForm" name="myForm" method="post">
				<div class="action">
					<div class="t">增加报销单</div>
					<div class="pages">
						<!--增加报销单 区域 开始-->
						<table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
							<!-- <tr>
								<td>填写人工号：</td>
								<td><input type="text" name="creator	"></input></td>
							</tr> -->
							<tr>
								<td>填报时间：</td>
								<td><input type="text" name="addDate" id="addDate" /></td>
							</tr>
							<tr>
								<td>总金额：</td>
								<td><input type="text" name="totalAccount" /></td>
							</tr>
							<tr>
								<td><input type="submit"/></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%-- </s:if>
		<s:else> 
		<h1>
			你还没登录，请您先登录。<a href="login.jsp">返回</a>
		</h1>
		</s:else>
 --%>
	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>

</body>
</html>