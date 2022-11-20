package com.atguigu.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取web.xml中配置的上下文参数
        ServletContext servletContext = getServletContext();
        System.out.println("servletContext.getInitParameter(\"username\") = " + servletContext.getInitParameter("username"));
        //2.  获取工程路径
        System.out.println("servletContext.getContextPath() = " + servletContext.getContextPath());
        //3.  获取工程部署后在服务器的绝对路径
        System.out.println("servletContext.getRealPath(\"/\") = " + servletContext.getRealPath("/"));
        //4.  像Map一样存取数据


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
