<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.ajax({
					//请求方式为get
					type : "GET",
					//json文件位置
					url : "user.json",
					//返回数据格式为json
					dataType : "json",
					//请求成功完成后要执行的方法
					success : function(data) {
						//使用$.each方法遍历返回的数据date,插入到id为#result中
						$.each(data, function(i, item) {
							var content = item.id + "," + item.name + ","
									+ item.birth + "</br>";
							$("#result").append(content);
						})
					}
				})
			});
</script>
</head>
<body>
	------u:${u}
	<p id="result"></p>
	<s:debug></s:debug>
</body>
</html>