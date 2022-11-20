<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script>
        $(function (){
            let status = $("#status").attr("data-status");
            console.log("status=="+status);
            console.log(typeof status);
            let eq = $("#status option").eq(status);
            eq.attr("selected","selected");
            console.log("count=="+${requestScope.count})


            $("#status").change(function (){
                let index=eq.attr("index");
                if (index==="1"){
                    location.href= "http://localhost:8080/Book_/orderServlet?action=sendOrder&orderId="+$("#status").attr("data-orderId");
                }else if (index==="2"){
                    location.href= "http://localhost:8080/Book_/orderServlet?action=receiverOrder&orderId="+$("#status").attr("data-orderId");
                }
            })

        })
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单管理系统</span>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <c:if test="${requestScope.count==2}">
            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
            </tr>
            <c:forEach items="${sessionScope.orderItems}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.count}</td>
                    <td>${item.price}</td>
                    <td>${item.totalPrice}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${requestScope.count==1}">
            <tr>
                <td>日期</td>
                <td>金额</td>
                <td>详情</td>
                <td>发货</td>
            </tr>
            <c:forEach items="${sessionScope.orderList}" var="order">
                <tr>
                    <td>${order.createTime}</td>
                    <td>${order.price}</td>
                    <td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
                    <td>
                        <select id="status" data-status="${order.status}" data-orderId="${order.orderId}">
                            <option index="1">未登录</option>
                            <option index="2">已发货</option>
                            <option index="3">已完成</option>
                        </select>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>

<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>