<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deptlist</title>
</head>
<body >
	<%
		if(request.getAttribute("deptlist") == null){
			response.sendRedirect("list.do");
			return;
		}
	%>
	<div align="center">
	<h2><a href="dept/adddept.jsp">添加部门</a></h2>
	<table border="2">
		<tr>
			<th>编号</th>
			<th>部门名称</th>
			<th>办公位置</th>
		</tr>
		<c:forEach items="${deptlist }" var="dept">
		<tr>
			<td>${dept.deptno }</td>
			<th>${dept.dname }</th>
			<th>${dept.loc }</th>
		</tr>
		</c:forEach>
		
	</table>
	</div>
</body>
</html>