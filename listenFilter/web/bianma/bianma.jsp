<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/24
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="<c:url value='/bianmaServlet?username=张三'/>">get请求</a>
    <form action="<c:url value='/bianmaServlet'/>" method="post">
        用户名：<input type="text" name="username"/>
        <input type="submit" value="登录"/>

    </form>
</body>
</html>
