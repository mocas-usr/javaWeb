<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/4
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" align="center" width="60%">
        <%
            for (int i=0;i<10;i++)
            {
        %>
        <tr>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        <tr>
            <td>张三</td>
            <td>26</td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>
