<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统登录 - 用户信息管理系统</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body class="blue-style">
<%--<c:if test="${sessionScope.loginUser != null}">
    <c:redirect url="http://localhost:8080/login"/>
</c:if>--%>
<div id="login">
    <div class="icon"></div>
    <div class="login-box">
        <form method="post" action="/login">
            <dl>
                <dt>用户名：</dt>
                <dd>
                    <input type="text" name="username" class="input-text" value="" />
                </dd>
                <dt>密 码：</dt>
                <dd>
                    <input type="password" name="password" class="input-text" />
                </dd>
            </dl>
            <div class="buttons">
                <input type="submit" name="submit" value="登录系统"
                    class="input-button" /> <input type="reset" name="reset"
                    value="重　　填" class="input-button" />
            </div>
        </form>
    </div>
</div>
</body>
</html>