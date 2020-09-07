<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/4
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Integer result=(Integer)request.getAttribute("result");/*将域对象，转换成Integer*/
    %>
    <%=result%>
</body>
</html>
