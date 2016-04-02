<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新部门</title>
</head>
<body>
	<div align="center">
	<%--借助springMVC标签库。实现信息提示 --%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
		<span style="color:red"><form:errors /></span>
		<form action="savedept.do" method="post">
			deptno:<input type="text" name="deptno" value="${dept.deptno }" />
			<%--path属性：把request中存贮dept对象中指定属性错误信息进行呈现 --%>
			<span style="color:red"><form:errors path="dept.deptno" /></span>
			<br/>
			deptname:<input type="text" name="dname" value="${dept.dname }" />
			<span style="color:red"><form:errors path="dept.dname" /></span>
			<br/>
			locatation:<input type="text" name="loc" value="${dept.loc }" /><br />
			<input type="submit" />
		</form>
	</div>
</body>
</html>




























