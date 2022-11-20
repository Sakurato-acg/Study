<%--
  Created by IntelliJ IDEA.
  User: lpl
  Date: 2022/11/15
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="loginservlet" method="get">
  用户名<input name="username" type="text" value="${cookie.username.value}">
  <br>
  密 码<input type="password" name="password">
  <br>
  <input type="submit" value="提交">
</form>
</body>
</html>
