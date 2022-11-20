<%--
  Created by IntelliJ IDEA.
  User: lpl
  Date: 2022/11/18
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/FilterA/">
</head>
<body>
<%
    System.out.println("aaaaaaa");
    Object user = session.getAttribute("user");
// 如果等于 null，说明还没有登录
    if (user == null) {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
    }
%>
jsp
</body>
</html>
