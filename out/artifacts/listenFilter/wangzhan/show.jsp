<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/23
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">显示结果</h1>
    <table align="center" width="60%" border="2">
        <tr>
            <td>ip</td>
            <td>次数</td>
        </tr>
        <c:forEach items="${map}" var="entry">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
