<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/5
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--本页面提供表单登录页面信息， 还要显示错误信息--%>
    <h1>登录</h1>
    <%

        /*读取名为username 的cookie*/
        String uname="";
        Cookie[] cs=request.getCookies();//获取所有请求cookie
        if (cs!=null)//如果存在cookie
        {
            for (Cookie c:cs)//循环遍历cookie
            {
                if ("uname".equals(c.getName()))//获取名称为uname的cookie
                {
                    uname=c.getValue();//将uname cookie的值赋给uname
                }
            }
        }
    %>
    <%
        String message="";
        String msg=(String) request.getAttribute("msg");
        if (msg!=null)
        {
            message=msg;
        }
    %>
    <font color="red"><b><%=message%></b></font>
    <form action="/jsp_demo/loginServlet" method="post">
        用户名：<input type="text" name="username"value="<%=uname%>"/> <br/>
        密码：<input type="password" name="password"/><br/>
        <input type="submit" value="登录"/>
    </form>


</body>
</html>
