<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/12
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>注册</h1>
<p style="color: red;font-weight: 900">${msg}</p><%--<p></p>//比br标签多空一行--%>
<%--${pageContext.request.contextPath}/registServlet这代表servlet的路径--%>
<%--下面也代表输出到servlet的路径，利用jstl的url标签--%>
<form action="<c:url value="/registServlet"/>" method="post">
    用户名：<input type="text" name="username" value="${user.username}"><br/>
    密 码：<input type="password" name="password" value="${user.password}"><br/>
    <input type="submit" value="注册"><br/>
</form>

</body>
</html>
