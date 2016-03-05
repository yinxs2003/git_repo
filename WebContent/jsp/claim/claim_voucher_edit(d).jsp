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
			if(checkFields("save")){
				myForm.submit();
			}
		}
			
		//提交报销单
		function submitAll(){
			var myForm = document.getElementById("myForm");
			var claimVoucherStatus = document.getElementById("status");
			claimVoucherStatus.value = "已提交";
			myForm.action = "saveEditClaimVoucher.action";
			if(checkFields("submitAll")){
				myForm.submit();
			}
		}
		
		// 添加报销单明细项
		function add_detail() {
			var tableDetail = document.getElementById("addform");
			var insertIndex = tableDetail.rows.length - 2;
			var newRow = tableDetail.insertRow(insertIndex);
			newRow.id = "row" + Math.random();	// 保证行Id的唯一性
			var colItem = newRow.insertCell(0);
			colItem.innerHTML = "<select name='items' id='select" + newRow.id + "' class='input_01' />";
			document.getElementById("select" + newRow.id).options.add(new Option("城际交通费", "城际交通费"));
			document.getElementById("select" + newRow.id).options.add(new Option("市内交通费", "市内交通费"));
			document.getElementById("select" + newRow.id).options.add(new Option("通讯费", "通讯费"));
			document.getElementById("select" + newRow.id).options.add(new Option("礼品费", "礼品费"));
			document.getElementById("select" + newRow.id).options.add(new Option("办公费", "办公费"));
			document.getElementById("select" + newRow.id).options.add(new Option("交际餐费", "交际餐费"));
			document.getElementById("select" + newRow.id).options.add(new Option("餐补", "餐补"));
			document.getElementById("select" + newRow.id).options.add(new Option("住宿费", "住宿费"));

			var colMoney = newRow.insertCell(1);
			colMoney.innerHTML = "<input type='text' name='accounts' class='input_01' />";
			var colDesc = newRow.insertCell(2);
			colDesc.innerHTML = "<input type='text' name='descriptions' class='input_01' />";
			var colOper = newRow.insertCell(3);
			// 在编辑窗体中包含报销单明细Id
			colOper.innerHTML = "<input type='hidden' name='ids' />";
			colOper.innerHTML += "<a href='javascript:save_detail(\"" + newRow.id + "\")' ><img src='images/save.gif' width='16' height='16' /></a>";
			colOper.innerHTML += " <a href='javascript:cancel_add(\"" + newRow.id + "\")' ><img src='images/delete.gif' width='16' height='16' /></a>";
		
			document.getElementById("addDetail").style.display = "none";	// 隐藏添加明细按钮
		}
		
		// 保存报销单明细
		function save_detail(rowId){
			var addRow = document.getElementById(rowId);
			var cells = addRow.getElementsByTagName("td");
			var detail_item = cells[0].firstChild.value;
			var detail_account = parseInt(cells[1].firstChild.value * 100) / 100;
			var detail_descript = cells[2].firstChild.value;
			var detail_id = cells[3].firstChild.value;
			
			if(checkFields('addDetail')){
				cells[0].innerHTML = "<input type='hidden' name='items' value='" + detail_item + "' />" + detail_item;
				cells[1].innerHTML = "<input type='hidden' name='accounts' value='" + detail_account + "' />￥" + detail_account;
				cells[2].innerHTML = "<input type='hidden' name='descriptions' value='" + detail_descript + "' />" + detail_descript;
				cells[3].innerHTML = "<input type='hidden' name='ids' value='" + detail_id + "'/>";
				cells[3].innerHTML += "<a href='javascript:edit_detail(\"" + addRow.id + "\")' ><img src='images/edit.gif' width='16' height='16' /></a>";
				cells[3].innerHTML += "<a href='javascript:delete_detail(\"" + addRow.id + "\")' ><img src='images/delete.gif' width='16' height='16' /></a>";
				
				calc_total();
				
				document.getElementById("addDetail").style.display = "";	// 显示添加明细按钮
			}
		}
		
		// 取消要添加的报销单明细项
		function cancel_add(rowid) {
						
			// 获取要删除行的索引
			var delRowIndex = document.getElementById(rowid).rowIndex;
			
			document.getElementById("addform").deleteRow(delRowIndex);
		
			document.getElementById("addDetail").style.display = "";	// 显示添加明细按钮
		}
		
	    //删除报销单详细信息
	    function delete_detail(rowid){
	    	if(confirm("要删除该条详细信息？")){
				cancel_add(rowid);
				calc_total();
			}else{
				return ;
			}
   		}
   		
		//将指定报销单详细信息添加到编辑文本框中
	    function edit_detail(rowid){
	    	var editRow = document.getElementById(rowid);
	    	var cells = editRow.getElementsByTagName("td");
			var detail_item = cells[0].firstChild.value;
			var detail_account = cells[1].firstChild.value;
			var detail_descript = cells[2].firstChild.value;
			var detail_id = cells[3].firstChild.value;
			cells[0].innerHTML = "<select name='items' id='select" + rowid + "' class='input_01' />";
			document.getElementById("select" + rowid).options.add(new Option("城际交通费", "城际交通费"));
			document.getElementById("select" + rowid).options.add(new Option("市内交通费", "市内交通费"));
			document.getElementById("select" + rowid).options.add(new Option("通讯费", "通讯费"));
			document.getElementById("select" + rowid).options.add(new Option("礼品费", "礼品费"));
			document.getElementById("select" + rowid).options.add(new Option("办公费", "办公费"));
			document.getElementById("select" + rowid).options.add(new Option("交际餐费", "交际餐费"));
			document.getElementById("select" + rowid).options.add(new Option("餐补", "餐补"));
			document.getElementById("select" + rowid).options.add(new Option("住宿费", "住宿费"));
			document.getElementById("select" + rowid).value = detail_item;
			
	    	cells[1].innerHTML = "<input type='text' name='accounts' class='input_01' value='" + detail_account + "' />";
		    cells[2].innerHTML = "<input type='text' name='descriptions' class='input_01' value='" + detail_descript + "' />";
		    // 报销单明细Id
		    cells[3].innerHTML = "<input type='hidden' name='ids' value='" + detail_id + "'/>";
		    cells[3].innerHTML += "<a href='javascript:save_detail(\"" + editRow.id + "\")' ><img src='images/save.gif' width='16' height='16' /></a>";
			cells[3].innerHTML += " <a href='javascript:delete_detail(\"" + editRow.id + "\")' ><img src='images/delete.gif' width='16' height='16' /></a>";
   		}
		
		// 计算报销单总价
		function calc_total(){
			var accounts = document.getElementsByName("accounts");
			var total_account = 0;
			for(var i = 0; i < accounts.length; i++){
				total_account += parseFloat(accounts[i].value);
			}
			total_account = parseInt(total_account * 100) / 100;
			document.getElementById("total_account").innerHTML = total_account;
			document.getElementById("totalAccount").value = total_account;
		}
		
   		//判空
	    function checkFields(opt){
	    	var claimVoucherEvent = document.getElementById("event");
			
			var claimVoucherDetailAccount = document.getElementsByName("accounts");
			
			var claimVoucherDetailAesc = document.getElementsByName("descriptions");
			
			if(opt=="addDetail"){
				for(var i = 0; i < claimVoucherDetailAccount.length; i++){
					if(claimVoucherDetailAccount[i].value==null||claimVoucherDetailAccount[i].value==""){
						claimVoucherDetailAccount[i].style.borderColor = "red";
						alert("金额不能为空");
						return false;
					}else if(claimVoucherDetailAesc[i].value==null||claimVoucherDetailAesc[i].value==""){
						claimVoucherDetailAesc[i].style.borderColor = "red";
						alert("费用说明不能为空");
						return false;
					}else{
						claimVoucherDetailAccount[i].style.borderColor = "black";
						claimVoucherDetailAesc[i].style.borderColor = "black";	
					}
				}
				return true;
			}else if(opt=="save"){
				if(claimVoucherEvent.value==null||claimVoucherEvent.value==""){
					claimVoucherEvent.style.borderColor = "red";
					alert("事由不能为空");
					return false;
				}else{
					claimVoucherEvent.style.borderColor = "black";
					return true;
				}
			}else if(opt=="submitAll"){
				if(claimVoucherEvent.value==null||claimVoucherEvent.value==""){
					claimVoucherEvent.style.borderColor = "red";
					alert("事由不能为空");
					return false;
				}else{
					for(var i = 0; i < claimVoucherDetailAccount.length; i++){
						if(claimVoucherDetailAccount[i].value==null||claimVoucherDetailAccount[i].value==""){
							claimVoucherDetailAccount[i].style.borderColor = "red";
							alert("金额不能为空");
							return false;
						}else if(claimVoucherDetailAesc[i].value==null||claimVoucherDetailAesc[i].value==""){
							claimVoucherDetailAesc[i].style.borderColor = "red";
							alert("费用说明不能为空");
							return false;
						}else{
							claimVoucherDetailAccount[i].style.borderColor = "black";
							claimVoucherDetailAesc[i].style.borderColor = "black";	
						}
					}
					claimVoucherEvent.style.borderColor = "black";
					return true;
				}
			}
       }
	</script>	
</head>
<body onload="setCurTime()">
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
							<a href="index.html" target="_self">添加报销单</a>
						</dd>
						<dd>
							<a href="list.html" target="_self">报销单管理</a>
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
										总金额：￥<span id="total_account"><s:i18n name="fmt"><s:text name="format.money"><s:param value="claimVoucher.totalAccount" /></s:text></s:i18n></span>
										<input type="hidden" name="claimVoucher.totalAccount" id="totalAccount" value="<s:i18n name="fmt"><s:text name="format.money"><s:param value="claimVoucher.totalAccount" /></s:text></s:i18n>" />
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
					  			  <s:set name="rowid" value="@@random()"></s:set>
								  <tr id="row<s:property value="%{#rowid}" />">
									<td><input type='hidden' name='items' value='<s:property value="#detail.item" />' /><s:property value="#detail.item" /></td>
									<td><input type='hidden' name='accounts' value='<s:i18n name="fmt"><s:text name="format.money"><s:param value="#detail.account" /></s:text></s:i18n>' />￥<s:i18n name="fmt"><s:text name="format.money"><s:param value="#detail.account" /></s:text></s:i18n></td>
									<td><input type='hidden' name='descriptions' value='<s:property value="#detail.description" />' /><s:property value="#detail.description" /></td>
									<td><input type='hidden' name='ids' value='<s:property value="#detail.id" />' />
										<a href='javascript:edit_detail("row" + <s:property value="%{#rowid}" />)' ><img src='images/edit.gif' width='16' height='16' /></a>
										<a href='javascript:delete_detail("row" + <s:property value="%{#rowid}" />)' ><img src='images/delete.gif' width='16' height='16' /></a>
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
