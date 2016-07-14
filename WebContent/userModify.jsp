<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="javascript/jquery.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<form method="post" action="UpdateUserServlet">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">用户ID：</td>
						<td><input type="text" name="userId" class="text"
							value="${before_user.userId }" /></td>
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" name="userName" class="text"
							value="${before_user.userName }" /></td>
					</tr>
					<tr>
						<td class="field">用户性别：</td>
						<td><select name="sex">
								<option value="男">男</option>
								<option value="女">女</option>
						</select></td>
					</tr>
					<tr>
						<td class="field">年龄：</td>
						<td><input type="text" name="age" value="${before_user.age}" /></td>
					</tr>
					<tr>
						<td class="field">手机号：</td>
						<td><input type="text" name="phoneNumber"
							value="${before_user.phoneNumber}" /></td>
					</tr>
					<tr>
						<td class="field">地址：</td>
						<td><input type="text" name="address"
							value="${before_user.address}" /></td>
					</tr>
					<tr>
						<td class="field">权限：</td>
						<td>${before_user.powerName}</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="window.parent.window.location.href='userIndex.jsp'" />
			</div>
		</form>
	</div>

</body>
</html>
