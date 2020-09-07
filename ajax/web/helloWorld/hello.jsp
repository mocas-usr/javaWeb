<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王宇航
  Date: 2020/5/25
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%----%>
    <title>Title</title>
    <script type="text/javascript">
        /*创建异步对象*/
        function createXMLHttpRequest() {
            try {
                return new XMLHttpRequest();
            } catch(e) {
                try {
                    return new ActiveXObject("Msxml2.XMLHTTP");//ie 6.0
                } catch(e) {
                    try {
                        return new ActiveXObject("Microsoft.XMLHTTP");// ie 5.5之前
                    } catch(e) {
                        alert("浏览器不支持");
                        throw e;
                    }
                }
            }
        }

        //js代码，例如向页面弹出一个框，显示内容
        window.onload=function () {//文档加载完毕后
            var btn=document.getElementById("btn");
            btn.onclick=function () {//按钮点击事件
                /*ajax四步操作
                * 把响应操作显示到h1
                * */
                /*1.得到异步对象*/
                var xmlHttp=createXMLHttpRequest();
                /*打开服务器连接*/
                xmlHttp.open("GET","<c:url value='/helloServlet'/>",true);
                /*3.发送请求*/
                xmlHttp.send(null);//get请求没有请求体，但也要给出null，不然浏览器可能会不发送
                /*4. 给异步对象事件注册器*/
                xmlHttp.onreadystatechange=function () {//大概xmlhttp状态发生变化时
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {//双重判断：判断是否为4状态，而且还要判断是否为200
                        // 获取服务器的响应内容
                        var text = xmlHttp.responseText;
                        var h1=document.getElementById("h1");
                        h1.innerHTML=text;
                    }


                }


            }
        }
    </script>

</head>
<body>
    <button id="btn">点击这里</button>
    <h1 id="h1"></h1>
</body>
</html>
