<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%-- 动态设置窗口标题 --%>
<s:set var="title" value="detail != null ? '编辑报销单明细' : '添加报销单明细'" />
<title><s:property value="#title" /></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body style="text-align:center">
	<h2 align="center"><s:property value="#title" /></h2>
	<%-- 动态设置表单提交action --%>
	<s:set var="formAction" value="detail != null ? 'saveEditClaimVoucherDetail' : 'addClaimVoucherDetail'" />
	<form action="<s:property value="#formAction" />" method="post">
	  <input type="hidden" name="detail.claimVoucher.id" value="${param.cid == null ? detail.claimVoucher.id :  param.cid}" />
	  <input type="hidden" name="detail.id" value="${ detail.id }" />
      <table align="center" width="400" border="0" cellpadding="0" cellspacing="10">
        <tr>
          <td>项目</td>
          <td><select name="detail.item" id="select" class="input_01">
	          	<option value="城际交通费">城际交通费</option>
				<option value="市内交通费">市内交通费</option>
				<option value="通讯费">通讯费</option>
				<option value="礼品费">礼品费</option>
				<option value="办公费">办公费</option>
				<option value="交际餐费">交际餐费</option>
				<option value="餐补">餐补</option>
				<option value="住宿费">住宿费</option>
              </select></td>
          <td><div id="error1"></div></td>
        </tr>
        <tr>
          <td>金额</td>
          <td><input type="text" name="detail.account" id="textfield2" class="input_01" value="<s:property value="detail.account"/>" /></td>
          <td><div id="error1"></div></td>
        </tr>
        <tr>
          <td>费用说明</td>
          <td><input type="text" name="detail.description" id="textfield" class="input_01" value="<s:property value="detail.description"/>" /></td>
          <td><div id="error1"></div></td>
        </tr>
        <tr>
          <td colspan="3"><input type="submit" id="button" value="保存" class="submit_01" /><input type="button" id="button" value="取消" class="submit_01" /></td>
        </tr>
      </table>
	</form>
</body>
</html>
