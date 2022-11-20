<%--
  Created by IntelliJ IDEA.
  User: lpl
  Date: 2022/10/28
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
   //1.
    pageContext.setAttribute("key", "pageContext");
    //2.
    request.setAttribute("key", "requestt");
    //3.
    session.setAttribute("key", "session");
    //4.
    application.setAttribute("key", "application");
%>
${key}
</body>
</html>
