<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script>
        $(function () {

            <%--if (${empty requestScope.e}){--%>
            <%--    confirm("未登录");--%>
            <%--}--%>
            $("#deleteOne , #deleteAll").click(function () {
                let b = confirm("要删除" + $(this).parent().parent().find("td:first").text() + "吗");
                return b;
            })
            $(".updateCount").change(function () {
                let name = $(this).parent().parent().find("td:first").text();
                console.log(name);
                let count = this.value;
                // alert(count);
                let id = $(this).attr("bookId");
                if (confirm("你确定要将【" + name + "】商品修改数量为" + count + "吗?")) {
                    location.href = "http://localhost:8080/Book_/cartServlet?action=updateCount&count=" + count + "&id=" + id;
                } else {
                    this.value = this.defaultValue;
                    //this.value=1
                }
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@ include file="/pages/common/login_success_menu.jsp" %>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
            <c:forEach items="${sessionScope.cart.items}" var="item">
                <tr>
                    <td>${item.value.name}</td>
                    <td><input class="updateCount"
                               bookId="${item.value.id}"
                               type="text" value="${item.value.count}" style="width: 50px; text-align: center"/></td>
                    <td>${item.value.price}</td>
                    <td>${item.value.totalPrice}</td>
                    <td><a id="deleteOne" href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
                </tr>
            </c:forEach>
    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="deleteAll" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>


</div>

<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>