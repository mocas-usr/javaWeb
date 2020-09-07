<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/12
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登陆</h1>
<%--显示错误信息--%>
<p style="color: red;font-weight: 900">${msg}</p><%--<p></p>//比br标签多空一行--%>
<form action="<c:url value="/loginServlet"/>" method="post">
    用户名：<input type="text" name="username" value="${user.username}"><br/>
    密 码：<input type="password" name="password" value="${user.password}"><br/>
    <input type="submit" value="登陆"><br/>
</form>
</body>
</html>
