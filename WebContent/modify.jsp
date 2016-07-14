<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="menu">
		<form method="get" action="QueryAdminServlet">
			商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			是否付款：<select name="havePay">
				<option value="">请选择</option>
				<option value="1">已付款</option>
				<option value="0">未付款</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="组合查询" class="button" />
		</form>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" name="button" value="添加数据"
				class="input-button" onclick="location.href='modify.jsp'" /></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="InsertAdminServlet">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td><input type="text" name="billId" class="text"
							value="${param.billId }" /></td>
					</tr>
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" name="commodityName" class="text"
							value="${param.commodityName }" /></td>
					</tr>
					<tr>
						<td class="field">商品单价：</td>
						<td><input type="text" name="price" class="text"
							value="${param.price }" /></td>
					</tr>
					<tr>
						<td class="field">商品数量：</td>
						<td><input type="text" name="commodityQuantity" class="text"
							value="${param.commodityQuantity }" /></td>
					</tr>
					<tr>
						<td class="field">单位：</td>
						<td><input type="text" name="unit" class="text"
							value="${param.unit }" /></td>
					</tr>
					<tr>
						<td class="field">所属供应商</td>
						<td><select name="supplierId">
								<option value="">请选择</option>
								<option value="1">大兴供应商</option>
								<option value="2">昌平供应商</option>
								<option value="3">石景山供应商</option>
						</select></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><textarea name="description" id="description">${questionnaire.description}</textarea></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="havePay">
								<option value="0">否</option>
								<option value="1">是</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
			</div>
		</form>
	</div>
	<script type="text/javascript" src="javascript/jquery.js"></script>
	<script type="text/javascript" src="javascript/birthday.js"></script>
	<script>
		$(function() {
			$.ms_DatePicker({
				YearSelector : ".sel_year",
				MonthSelector : ".sel_month",
				DaySelector : ".sel_day"
			});
			$.ms_DatePicker();
		});
	</script>
</body>
</html>
