<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body class="frame-bd">
<ul class="left-menu">
    <li><a href="QueryAdminServlet" target="mainFrame"><img
            src="images/btn_bill.gif"/></a></li>
    <li><a href="QueryProviderServlet" target="mainFrame"><img
            src="images/btn_suppliers.gif"/></a></li>
    <li><a href="user/findAll" target="mainFrame"><img
            src="images/btn_users.gif"/></a></li>
    <!-- <li><a href="#" onclick="javascript:logout()"><img src="images/btn_exit.gif" /></a></li> -->
    <li><a href="LogOut" onclick=""><img
            src="images/btn_exit.gif"/></a></li>
</ul>
<script type="text/javascript">
    function logout() {
        console.log("logout()");
        //parent.location.reload();

    }

    function logout2() {
        console.log("logout2()");
        //parent.location.reload();

    }
</script>
</body>
</html>
