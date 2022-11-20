<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员登录页面</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            $("#sub_btn").click(function () {
                let username = $("#username").val();
                let password = $("#password").val();
                if ($.trim(username) == null || username === "") {
                    $('span.errorMsg').text("用户名不能为空");
                    return false;
                }
                if ($.trim(password) == null || password === "") {
                    $('span.errorMsg').text("密码不能为空");
                    return false;
                }
                <jsp:include page="/pages/common/login_success_menu.jsp">
                    <jsp:param name="username" value='<%= request.getAttribute("username")%>'/>
                </jsp:include>
            })
        });

    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>尚硅谷会员</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">${empty requestScope.err?'请输入用户名和密码':requestScope.err}</span>

                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login">
                        <label>用户名称：</label>
                        <input class="itxt" id="username" type="text" placeholder="请输入用户名" autocomplete="off"
                               tabindex="1"
                               name="username" value="${ empty requestScope.username?cookie.username.value:requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" id="password" type="password" placeholder="请输入密码" autocomplete="off"
                               tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>