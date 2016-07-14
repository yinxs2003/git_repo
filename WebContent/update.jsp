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
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="UpdateAdminServlet">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td><input type="text" name="billId" class="text"
							value="${bill.billId }" /></td>
					</tr>
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" name="commodityName" class="text"
							value="${bill.commodityName }" /></td>
					</tr>
					<tr>
						<td class="field">交易金额：</td>
						<td><input type="text" name="sumPrice" class="text"
							value="${bill.sumPrice }" /></td>
					</tr>
					<tr>
						<td class="field">商品数量：</td>
						<td><input type="text" name="commodityQuantity" class="text"
							value="${bill.commodityQuantity }" /></td>
					</tr>
					<tr>
						<td class="field">单位：</td>
						<td><input type="text" name="commodityUnit" class="text"
							value="${bill.commodityUnit}" /></td>
					</tr>
					<tr>
						<td class="field">所属供应商</td>
						<td><select name="providerId">
								<c:forEach var="provider" items="${before_providerList}">
									<option value="${provider.providerId}"
										<c:if test="${provider.providerId eq bill.providerId}">selected</c:if>>${provider.providerName}
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><textarea name="commodityDesc" id="commodityDesc">${bill.commodityDesc}</textarea></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="havePay">
								<option value="0"
									<c:if test="${'0' eq bill.havePay}">selected</c:if>>否</option>
								<option value="1"
									<c:if test="${'1' eq bill.havePay}">selected</c:if>>是</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="script:window.parent.window.location.href='admin_index.jsp'" />
			</div>
		</form>
	</div>
</body>
</html>
