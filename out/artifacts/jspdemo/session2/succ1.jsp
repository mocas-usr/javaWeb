<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/5
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    /*避免直接跳转这个界面时 ，出现登录成功界面*/
    String username=(String)session.getAttribute("username");
    if (username==null)
    {
        request.setAttribute("msg","您还没有登录成功");
        /*使用请求转发，可以保留request的存储信息，使用同一request*/
        request.getRequestDispatcher("/session2/login.jsp").forward(request,response);
        return;
    }
%>
    <h1>登录成功</h1>
        欢迎欢迎，热烈欢迎，欢迎<%=username%>领导

</body>
</html>
