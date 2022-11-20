<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lpl
  Date: 2022/10/28
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%--< c:set > 可以在域中保存数据--%>
<c:set scope="request" var="abc" value="abcValue"/>
    ${requestScope.abc}<br>
<hr/>


<%-- < c:if > if判断--%>
<%--test属性表示判断的条件 (EL的表达式) --%>
<c:if test="${12==12}">
    <h1>if判断<h1/>
</c:if>
<hr/>




    <%--< c:choose >< c:when >< c:otherwise > --%>
    <%--作用：多路判断 跟swith case default一样--%>
        <%
        request.setAttribute("height",199);
        %>
    <c:choose>
            <c:when test="${height>190}">
                <h1>190<h1/>
            </c:when>
            <c:when test="${height>170}">
                <h1>170<h1/>
            </c:when>
            <c:otherwise>
                <h1>otherwise<h1/>
            </c:otherwise>
    </c:choose>

<hr/>

</body>
</html>
