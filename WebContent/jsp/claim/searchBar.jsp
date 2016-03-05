<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div><h1>searchBar.jsp,提交到addClaimVoucher</h1>
	<div class="forms">
		<s:form action="showClaimVoucherByCondition" name="showClaimVoucherByCondition">
			<!-- <label>报销单状态: </label> -->
			<%-- <s:select name="claimVoucher.status" list="claimVoucherList"
					listKey="claimVoucher.creator.name" listValue="claimVoucher.status"
					headerKey="" headerValue="全部" theme="simple"></s:select> --%>
			<label for="status">报销单状态: </label>
			<s:select list="#{'新创建':'新创建','已打回':'已打回','已审批':'已审批'}" name="status" id="status"
				headerKey="" headerValue="全部" theme="simple" />&nbsp;
				<label for="time">开始时间: </label>
			<s:textfield name="startDate" id="startDate" cssClass="nwinput"
				theme="simple"></s:textfield>&nbsp;

				<label for="end-time">结束时间: </label>
			<s:textfield name="endDate" id="endDate" cssClass="nwinput"
				theme="simple"></s:textfield>&nbsp;
				<input type="hidden" name="pageNo" value="1" />
			<input type="hidden" name="pageSize" value="5" />
			<s:submit cssClass="submit_01" value="查询" theme="simple" />
		</s:form>
	</div>
</div>	