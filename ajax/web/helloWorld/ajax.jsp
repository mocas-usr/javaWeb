<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/25
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function createXMLHttpRequest() {
            try {
                return new XMLHttpRequest();
            } catch(e) {
                try {
                    return new ActiveXObject("Msxml2.XMLHTTP");
                } catch(e) {
                    try {
                        return new ActiveXObject("Microsoft.XMLHTTP");
                    } catch(e) {
                        alert("浏览器不支持");
                        throw e;
                    }
                }
            }
        }

        window.onload=function () {//导入页面之后的事件方法
            /*获取文本框*/
            var userele=document.getElementById("usernameele");
            /*给他失去焦点事件注册监听*/
            userele.onblur=function () {
                /*得到异步对象*/
                var xmlHttp=createXMLHttpRequest();
                /*2打开链接*/
                xmlHttp.open("POST","<c:url value='/validServlet'/>",true);
                /*3设置请求头*/
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                /*3.发送请求*/
                // xmlHttp.send(null);//get请求没有请求体，但也要给出null，不然浏览器可能会不发送
                xmlHttp.send("username="+userele.value);//POST
                /*给xml注册监听器*/
                xmlHttp.onreadystatechange = function() {//xmlHttp的5种状态都会调用本方法
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {//双重判断：判断是否为4状态，而且还要判断是否为200
                        // 获取服务器的响应内容
                        var text = xmlHttp.responseText;
                        if (text=="1")
                        {
                            var span=document.getElementById("errorspan")
                            span.innerHTML="用户名已经被注册";

                        }
                        else
                        {
                            span.innerHTML="";
                        }
                    }
                };



            }

        }
    </script>
</head>
<body>

<h1>检查用户名是否被注册</h1>
<form action="<c:url value='' />" method="post">
    用户名:<input type="text" name="username" id="usernameele"/><span id="errorspan"></span><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="提交"/>

</form>
</body>
</html>
