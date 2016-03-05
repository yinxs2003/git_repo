<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><base  />
	<title>北大青鸟办公自动化管理系统</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		//保存报销单
		function save(){
			var myForm = document.getElementById("myForm");
			var claimVoucherStatus = document.getElementById("status");
			myForm.action = "saveEditClaimVoucher.action";
			myForm.submit();
		}
			
		//提交报销单
		function submitAll(){
			var myForm = document.getElementById("myForm");
			var claimVoucherStatus = document.getElementById("status");
			claimVoucherStatus.value = "已提交";	// 修改报销单状态
			myForm.action = "saveEditClaimVoucher.action";
			myForm.submit();
		}
		
		// 添加报销单明细项
		function add_detail() {
			var x,y;
			x = (window.screen.width - 500)/2;
			y = (window.screen.height - 280)/2;
			// 弹出添加报销单明细窗口，当前的报销单Id通过参数传递
			window.open("claim_voucher_detail_edit.jsp?cid="+ <s:property value="claimVoucher.id" />,"_blank","top="+y+",left="+x+",width=500px,height=280px");
			
			//document.getElementById("addDetail").style.display = "none";	// 隐藏添加明细按钮
		}
		
		// 编辑报销单明细
		function edit_detail(did) {
			var x,y;
			x = (window.screen.width - 500)/2;
			y = (window.screen.height - 280)/2;
			// 通过Action调用查询报销单明细，弹出编辑报销单明细窗口，当前的报销单明细Id通过参数传递
			window.open("editClaimVoucherDetail?id="+ did,"_blank","top="+y+",left="+x+",width=500px,height=280px");
		}
		
		// 删除报销单明细
		function delete_detail(did,cid){
			if(confirm("确认真的要删除该报销单明细项？")){
				window.location.href='deleteClaimVoucherDetail?id='+did+'&cid='+cid;
			}
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
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
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
							增加报销单
						</div>
						<div class="pages">
							<!--编辑报销单 区域 开始-->
							<table width="90%" border="0" cellspacing="0" cellpadding="0"
								class="addform-base">
								<caption>
									基本信息
									<input type="hidden" name="claimVoucher.id" value="<s:property value="claimVoucher.id" />" />
								</caption>
								<tr>
									<td width="36%">
										填写人：<s:property value="claimVoucher.creater.name" />
										<input type="hidden" name="claimVoucher.creater.sn" value="<s:property value="claimVoucher.creater.sn" />" />
									</td>
									<td width="64%">
										填报时间：<s:i18n name="fmt"><s:text name="format.date"><s:param value="claimVoucher.createTime" /></s:text></s:i18n>
										<input type="hidden" name="claimVoucher.createTime" id="createTime" value="<s:property value="claimVoucher.createTime" />" />
									</td>
								</tr>
								<tr>
									<td>
										总金额：￥<span id="total_account"><s:property value="claimVoucher.totalAccount" /></span>
										<input type="hidden" name="claimVoucher.totalAccount" id="totalAccount" value="<s:property value="claimVoucher.totalAccount" />" />
									</td>
									<td>
										状态：<s:property value="claimVoucher.status" />
										<input type="hidden" id="status" name="claimVoucher.status" value="<s:property value="claimVoucher.status" />" />
									</td>
								</tr>
							</table>
							<p>&nbsp;
								
							</p>
							<table id="addform" width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-item">
								<thead>
									<tr>
										<td>
											项目
										</td>
										<td>
											金额
										</td>
										<td>
											费用说明
										</td>
										<td>
											操作
										</td>
									</tr>
								</thead>
								<s:if test="claimVoucher.claimVoucherDetails!=null">
					  			  <s:iterator value="claimVoucher.claimVoucherDetails" var="detail">
								  <tr>
									<td><s:property value="#detail.item" /></td>
									<td>￥<s:i18n name="fmt"><s:text name="format.money"><s:param value="#detail.account" /></s:text></s:i18n></td>
									<td><s:property value="#detail.description" /></td>
									<td><a href='javascript:edit_detail(<s:property value="#detail.id" />)' ><img src='images/edit.gif' width='16' height='16' /></a>
										<a href='javascript:delete_detail(<s:property value="#detail.id" />,<s:property value="claimVoucher.id" />)' ><img src='images/delete.gif' width='16' height='16' /></a>
									</td>
								  </tr>
								  </s:iterator>
								</s:if>
								<!--报销单事由-->
								<tr>
									<td colspan="4" class="event">
										<label>
											事 由：
										</label>
											<textarea rows="5" cols="66" name="claimVoucher.event" id="event"><s:property value="claimVoucher.event" /></textarea>
									</td>
								</tr>
                                
								<!--表单提交行-->
								<tr>
									<td colspan="4" class="submit">
                                    	<input type="button" id="addDetail" value="添加明细" onclick="add_detail()" class="submit_01" />
										<input type="button" id="1" name="1" value="保存" onclick="save()" class="submit_01" />
										<input type="button" id="2" name="2" value="提交" onclick="submitAll()" class="submit_01" />
									</td>
								</tr>
							</table>
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
