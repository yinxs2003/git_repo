<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册</h1>
	<form action="mvc/reg.do" method="post">
		username:
		<input type="text" name="username">
		password:
		<input type="text" name="password">
		出生日期：
		<input type="text" name="birth">
		工作年限
		<input type="text" name="workTime" />
		<input type="submit" />
	</form>
</body>
</html>