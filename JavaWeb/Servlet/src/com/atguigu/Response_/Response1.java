package com.atguigu.Response_;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //给客户端回传 字符串 数据
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html;Charset=UTF-8");
        response.sendRedirect("http://localhost:8080/06Tomcat_Servlet/a.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
