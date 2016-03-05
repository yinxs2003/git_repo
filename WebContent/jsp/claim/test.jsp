<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
</head>

<body>
	<h1>Struts 2 i18n tag example</h1>

	<h2>1.Get message from I18nTagAction.properties</h2>
	Output :
	<s:text name="i18n.msg" />

	<h2>2.Get message from Custom.properties</h2>
	Output :
	<s:i18n name="com/mkyong/common/action/Custom">
		<s:text name="i18n.msg" />
	</s:i18n>
	-----------------------
	<s:action name="com.action.Pager" var="pageAction"></s:action>
	<s:property value="#pageAction。getTotalPage()"/>
</body>
</html>
