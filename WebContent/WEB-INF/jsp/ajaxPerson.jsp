<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<!-- jQuery.post(url,data,success(data, textStatus, jqXHR),dataType) -->
<script type="text/javascript">
	$(function() {
		$("#bn").click(function() {
			//console.log("hello");
			$.post("getPerson", {
				name : $("#name").val()
			}, function(data) {
				alert(data);
			});
		});
	});
</script>
</head>
<body>
	----ajaxPerson.jsp
	<br />
	<form action="">
		姓名：<input type="text" id="name">
		<input type="button" id="bn" value="提交" />
	</form>
	--------name:${name }
</body>
</html>