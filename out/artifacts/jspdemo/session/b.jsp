<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/5
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>获取session数据</h1>
    <%
        String s=(String) session.getAttribute("aaa");
    %>
    <%=s%>
</body>
</html>
