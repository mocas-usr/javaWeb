<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/7
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="it" uri="/WEB-INF/tlds/hello.tld" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><it:hello/></h1>
    <%--如果xxx没设参数，则执行下面内容，如果设置xxx，则不执行--%>
    <it:mytag4 test="${empty param.xxx}">
        <h1><it:mytag3>我是张三</it:mytag3></h1>
    </it:mytag4>



</body>
</html>
