<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/4
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--java代码片段--%>
<%
    String path=request.getContextPath();

    /*http://localhost:8080/hello/BServlet*/
    String basePath=request.getScheme()+"//"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>

<html>
  <head>
    <%--向页面输出basepath--%>
      <base href="<%=basePath %>">
    <title>$Title$</title>
  </head>
  <body>
  this is my page
  <%
    int a=10;
  %>
  <%
    out.print(a++);
  %>
  <br/>
  <%=a%>

  <%!
    int a=100;
  %>
  <%
    out.print(this.a++);
  %>
  </body>
</html>
