<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        function doit(flag, id) {
            if (flag == "del") {
                if (confirm("确认删除吗？") != true)
                    return;
            }
        }
    </script>
</head>
<body>
<div class="menu">
    <table>
        <tr>
            <td>
                <form method="post" action="QueryUserServlet">
                    用户名称：<input type="text" name="userName" class="input-text"
                                value="${userName}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
                                                    value="查 询" class="button"/>
                </form>
            </td>
        </tr>
    </table>
</div>
<div class="main">
    <div class="optitle clearfix">
        <em><input value="添加数据" class="input-button"
                   onclick="window.location='userAdd.jsp'" type="button"></em>
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tr>
                <td>
                    <div class="STYLE1" align="center">编号</div>
                </td>
                <td>
                    <div class="STYLE1" align="center">用户名</div>
                </td>

                <td>
                    <div class="STYLE1" align="center">密码</div>
                </td>
                <%--<td width="100">
                    <div class="STYLE1" align="center">性别</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">年龄</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">电话</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">地址</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">权限</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">操作</div>
                </td>--%>
            </tr>
            <%--userList: ${userList}--%>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td><c:out value="${user.id}"></c:out></td>
                    <td><c:out value="${user.username}"></c:out></td>
                    <td><c:out value="${user.password}"></c:out></td>
                    <td>
                        <a
                            href='UserInitServlet?userId=${user.userId}
							&userName=${user.userName}
							&sex=${user.sex}
							&age=${user.age}&providerAddress=${user.phoneNumber}
							&address=${user.address }&$power=${user.power}
							'>修改</a>
                        <a href='DeleteUserServlet?userId=${user.userId}'>删除</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <c:forEach var="pageNow" begin="1" end="${pageCount}">
        <c:if test="${fn:length(userName) == 0}">
            <a
                    href="<c:out value="QueryUserServlet?pageNow=${pageNow}"></c:out>">[${pageNow}]</a>
        </c:if>
        <c:if test="${fn:length(userName) != 0}">
            <a
                    href="<c:out value="QueryUserServlet?pageNow=${pageNow}&userName=${userName}"></c:out>">[${pageNow}]</a>
        </c:if>
    </c:forEach>

</div>
</body>
</html>