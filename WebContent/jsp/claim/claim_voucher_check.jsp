<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>北大青鸟办公自动化管理系统</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function pass(){
				var myForm = document.getElementById("myForm");
				myForm.action = "passClaimVoucher.action";
				myForm.submit();
			}	
			function regist(){
				var myForm = document.getElementById("myForm");
				myForm.action = "refuseClaimVoucher.action";
				myForm.submit();
			}
		
			function back(){
				var myForm = document.getElementById("myForm");
				myForm.action = "backClaimVoucher.action";
				myForm.submit();
		    }
		</script>
	</head>

	<body>
		<s:if test="%{#session.employee!=null}">
			<div class="top">
				<div class="global-width">
					<img src="images/logo.gif" class="logo" />
				</div>
			</div>
			<div class="status">
				<div class="global-width">
					<span class="usertype">【登录角色：<s:property value="%{#session.employee.position.nameCn}" />】</span><s:property value="%{#session.employee.name}" />你好！欢迎访问青鸟办公管理系统！
					<a href="loginOut.action">注销</a>
				</div>
			</div>
			<div class="main">
				<div class="global-width">
					<div class="nav" id="nav">
						<div class="t"></div>
						<dl class="open">
							<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
								报销单管理
							</dt>
							<dd>
								<a href="addClaimVoucher.action" target="_self">添加报销单</a>
							</dd>
							<dd>
								<a href="listClaimVoucher.action" target="_self">报销单管理</a>
							</dd>
						</dl>
						<dl>
							<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
								我要采购
							</dt>
							<dd>
								信心收件箱
							</dd>
							<dd>
								信心发件箱
							</dd>
						</dl>
						<dl>
							<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
								我要销售
							</dt>
							<dd>
								信心收件箱
							</dd>
							<dd>
								信心发件箱
							</dd>
						</dl>
						<dl>
							<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
								信息中心
							</dt>
							<dd>
								信心收件箱
							</dd>
							<dd>
								信心发件箱
							</dd>
						</dl>
					</div>
					<form id="myForm" name="myForm" method="post">
						<div class="action">
							<div class="t">
								审核报销单
							</div>
							<div class="pages">
								<!--增加报销单 区域 开始-->
								<table width="90%" border="0" cellspacing="0" cellpadding="0"
									class="addform-base">
									<caption>
										基本信息
									</caption>
									<tr>
										<td width="36%">
											填写人：
											<input type="hidden" name="claimVoucher.id"	value="<s:property value="claimVoucher.id" />" />
											<s:property value="claimVoucher.creator.name" />
										</td>
										<td width="64%">
											填报时间：
											<s:date name="claimVoucher.createTime" format="yyyy-MM-dd" />
										</td>
									</tr>
									<tr>
										<td>
											总金额：<s:property value="claimVoucher.totalAccount" />
										</td>
										<td>
											状态：<s:property value="claimVoucher.status" />
										</td>
									</tr>
								</table>
								<p>&nbsp;</p>
								<table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
									<tr>
										<td>项目</td>
										<td>金额</td>
										<td>费用</td>
									</tr>
									 <s:if test="claimVoucher.claimVoucherDetails!=null">
						  			  <s:iterator value="claimVoucher.claimVoucherDetails" var="detail">
									  <tr>
										<td><s:property value="#detail.item" /></td>
										<td>￥<s:property value="#detail.account" /></td>
										<td><s:property value="#detail.description" /></td>
									  </tr>
									  </s:iterator>
						  			</s:if>
								</table>
								<p>
									&nbsp;
								</p>
								<p>
									-------------------------------------------------------------------------------
								</p>
								<p>
									&nbsp;
								</p>
								<table width="90%" border="0" cellspacing="0" cellpadding="0"
									class="addform-base">
									<s:iterator value="checkResultList" var="checkResult">
							         <tr>
							           <td width="27%"><s:property value="#checkResult.checker.sn" />(<s:property value="#checkResult.checker.positon.nameCn" />)</td>
							           <td width="20%"><s:property value="#checkResult.checkTime" /></td>
							           <td width="38%">审核：<span class="red"><strong><s:property value="#checkResult.result" /></strong></span></td>
							         </tr>
							         <tr>
							           <td>审核意见：<s:property value="#checkResult.comm" /></td>
							           <td>&nbsp;</td>
							           <td>&nbsp;</td>
							         </tr>
								   </s:iterator>
								</table>
								<p>
									&nbsp;
								</p>
								<table width="90%" border="0" cellspacing="0" cellpadding="0"
									class="addform-base">
									<tr>
										<td>
											审核意见：
										</td>
									</tr>
									<tr>
										<td>
											<textarea name="checkResult.comm" id="textarea" cols="45" rows="5"></textarea>
										</td>
									</tr>
									<!--表单提交行-->
									<tr>
										<td colspan="4" class="submit">
											<input type="button" name="button" id="button" value="审核通过"
												class="submit_01" onclick="pass()" />
											<c:choose>
												<c:when test="${sessionScope.employee.position.id!=4}">
													<input type="button" name="button" id="button" value="审核拒绝"
														class="submit_01" onclick="regist()" />
													<input type="button" name="button" id="button" value="打回"
														class="submit_01" onclick="back()" />
												</c:when>
											</c:choose>
										</td>
									</tr>

								</table>
								<p>
									&nbsp;
								</p>
								<p>
									&nbsp;
								</p>
								<p>
									&nbsp;
								</p>
								<!--增加报销单 区域 结束-->
							</div>
						</div>
					</form>
				</div>
			</div>

		</s:if>
		<s:else>
			<h1>
				你还没登录，请您先登录。
				<a href="login.jsp">返回</a>
			</h1>
		</s:else>
		<div class="copyright">
			Copyright &nbsp; &copy; &nbsp; 北大青鸟
		</div>

	</body>
</html>