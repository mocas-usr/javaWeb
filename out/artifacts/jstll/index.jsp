<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/7
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--out，set的使用--%>
  <c:set var="code" value="<script>alert('hello');</script>" scope="request" />
  <c:out value="${code}" default="" escapeXml="true" /><br/>

  <c:if test="${empty param.name}"><%--如果name为空，则执行--%>
      您还没有给出name的名称
  </c:if>
  <%--if else的使用--%>
  <c:choose>
    <c:when test="${empty param.name}">
      您还没给名称
    </c:when>
    <c:otherwise>
      谁让你给出名称的？
    </c:otherwise>
  </c:choose>

<%
  ArrayList<String> list=new ArrayList<String>();
  list.add("一");
  list.add("二");
  list.add("三");

  pageContext.setAttribute("list",list);
%>
<hr/><%--水平线标签  --%>
  <c:forEach items="${list} " var="ele" varStatus="vs">
    ${vs.count} ${vs.index} ${vs.first} ${vs.last}<br/>
     ${ele} <br/>
  </c:forEach>


  </body>
</html>
