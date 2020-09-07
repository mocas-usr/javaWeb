<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/12
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎，欢迎！热烈欢迎~</h1>
    <c:choose>
        <%--如果直接登录，将会缺值--%>
        <c:when test="${empty sessionScope.sessionuser}">Go out！</c:when>
        <%--正常登录情况下的，显示的内容--%>
        <c:otherwise>${sessionScope.sessionuser}</c:otherwise>
    </c:choose>

</body>
</html>
