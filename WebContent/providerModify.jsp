<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<form method="post" action="ProviderInitServlet">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">供应商编号：</td>
						<td><input type="text" name="providerId" class="text"
							value="${param.providerId}" /></td>
					</tr>
					<tr>
						<td class="field">供应商名称：</td>
						<td><input type="text" name="providerName" class="text"
							value="${param.providerName }" /></td>
					</tr>
					<tr>
						<td class="field">供应商描述：</td>
						<td><input type="text" name="providerDesc" class="text"
							value="${param.providerDesc }" /></td>
					</tr>
					<tr>
						<td class="field">供应商电话：</td>
						<td><input type="text" name="providerMobile" class="text"
							value="${param.providerMobile}" /></td>
					</tr>
					<tr>
						<td class="field">供应商地址：</td>
						<td><input type="text" name="providerAddress" class="text"
							value="${param.providerAddress}" /></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back()" />
			</div>
		</form>
	</div>
</body>
</html>
