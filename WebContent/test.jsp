<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>

<body>
	<s:iterator value="{1,5,6,2,3,4,5,19}" var="idx" status="i">
		<s:property value="idx"/>
	</s:iterator>
	<s:debug></s:debug>
</body>
</html>
