<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Bill"%>
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
	<form method="post" action="MyTestServlet">
		商品名称： <input type="text" name="productName" class="input-text" value="${param.productName}"/>
		商品名称： <input type="text" name="productName" class="input-text" value=""/>
		 <input
			type="submit" name="submit" value="组合查询" class="button" />
	</form>
</body>
</html>
