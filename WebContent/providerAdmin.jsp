<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="com.entity.Bill"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
		window.location = "provider.do?id=" + id + "&flag=" + flag;
	}
</script>
<body>
	<div class="menu">
		<form method="post" action="QueryProviderServlet">
			供应商名称：<input type="text" name="providerName" class="input-text"
				value="${providerName}" />&nbsp;&nbsp;&nbsp;&nbsp; 供应商描述：<input
				type="text" name="providerDesc" class="input-text"
				value="${providerDesc}" />&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="组合查询" class="button" />
		</form>
	</div>

	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="location.href='providerAdd.jsp'" type="button"></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
				<tr>
					<td>编号</td>
					<td>供应商名称</td>
					<td>供应商描述</td>
					<td>电话</td>
					<td>地址</td>
					<td>操作</td>
				</tr>
				<c:forEach var="provider" items="${providerList}">
					<tr>
						<td><c:out value="${provider.providerId}"></c:out></td>
						<td><c:out value="${provider.providerName}"></c:out></td>
						<td><c:out value="${provider.providerDesc}"></c:out></td>
						<td><c:out value="${provider.providerMobile}"></c:out></td>
						<td><c:out value="${provider.providerAddress}"></c:out></td>
						<td><a
							href='providerModify.jsp?providerId=${provider.providerId}
							&providerName=${provider.providerName}
							&providerDesc=${provider.providerDesc}
							&providerMobile=${provider.providerMobile}&providerAddress=${provider.providerAddress}
							'>修改</a>
							<a href='DeleteProviderServlet?providerId=${provider.providerId}'>删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<c:forEach var="pageNow" begin="1" end="${pageCount}">
		<c:if
			test="${fn:length(providerName) == 0 && fn:length(providerDesc) == 0 }">
			<a
				href="<c:out value="QueryProviderServlet?pageNow=${pageNow}"></c:out>">[${pageNow}]</a>
		</c:if>
		<c:if
			test="${fn:length(providerName) != 0 && fn:length(providerDesc) == 0 }">
			<a
				href="<c:out value="QueryProviderServlet?pageNow=${pageNow}&providerName=${providerName}"></c:out>">[${pageNow}]</a>
		</c:if>
		<c:if
			test="${fn:length(providerName) == 0 && fn:length(providerDesc) != 0 }">
			<a
				href="<c:out value="QueryProviderServlet?pageNow=${pageNow}&providerDesc=${providerDesc}"></c:out>">[${pageNow}]</a>
		</c:if>
		<c:if
			test="${fn:length(providerName) != 0 && fn:length(providerDesc) != 0 }">
			<a
				href="<c:out value="QueryProviderServlet?pageNow=${pageNow}&providerName=${providerName}&providerDesc=${providerDesc}"></c:out>">[${pageNow}]</a>
		</c:if>
	</c:forEach>

</body>
</html>