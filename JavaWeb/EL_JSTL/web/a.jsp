<%--
  Created by IntelliJ IDEA.
  User: lpl
  Date: 2022/10/28
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Title</title>
</head>
<style>
    html{
        font-size: 30px;
    }
</style>
<body>
<%
    request.setAttribute("key","zhi");
    //null
%>

表达式输出的是<%=request.getAttribute("key")%>
<br/>
EL表达式:${key}
</body>
</html>
