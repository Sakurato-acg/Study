<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lpl
  Date: 2022/10/25
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
JSP
<%--声明类属性--%>
<%! private int id;
    private String name;
    private static Map<String, Object> map;
%>
<%!
    static {
        map = new HashMap<>();
        map.put("test", "value1");
    }
%>
<%=
1234
%>
<% for (int i = 0; i < 10; i++) { %>
<%= System.out.println(i) %>
<% }%>
<div style="background-color: red;width: 100%;height: 10px"></div>
</body>
</html>
