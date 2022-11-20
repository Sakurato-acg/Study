package com;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        String pass=request.getParameter("password");

        if ("nanami".equals(name) &&"123456".equals(pass)){
            Cookie cookie = new Cookie("username", name);
            cookie.setMaxAge(30);//60s
            response.addCookie(cookie);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            System.out.println("登陆失败");
        }
    }

}
