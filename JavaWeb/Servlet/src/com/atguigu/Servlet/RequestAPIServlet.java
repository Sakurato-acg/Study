package com.atguigu.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Arrays;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. getRequestURI() 获取请求的资源路径
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
//        2. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
//        3. getRemoteHost() 获取客户端的 ip 地址
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
//        4. getHeader() 获取请求头
        System.out.println("request.getHeader(\"User-Agent\") = " + request.getHeader("User-Agent"));
//        5. getParameter() 获取请求的参数
        System.out.println("request.getParameter(\"username\") = " + request.getParameter("username"));
        System.out.println("request.getParameter(\"password\") = " + request.getParameter("password"));
//        6. getParameterValues() 获取请求的参数（多个值的时候使用）
//        7. getMethod() 获取请求的方式 GET 或 POST
        System.out.println("request.getMethod() = " + request.getMethod());
//        8. setAttribute(key, value); 设置域数据
//        9. getAttribute(key); 获取域数据
//        10. getRequestDispatcher() 获取请求转发对象
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //        1. getRequestURI() 获取请求的资源路径
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
//        2. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
//        3. getRemoteHost() 获取客户端的 ip 地址
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
//        4. getHeader() 获取请求头
        System.out.println("request.getHeader(\"User-Agent\") = " + request.getHeader("User-Agent"));
//        5. getParameter() 获取请求的参数
        System.out.println("request.getParameter(\"username\") = " + request.getParameter("username"));
        System.out.println("request.getParameter(\"password\") = " + request.getParameter("password"));
//        6. getParameterValues() 获取请求的参数（多个值的时候使用）
//        7. getMethod() 获取请求的方式 GET 或 POST
        System.out.println("request.getMethod() = " + request.getMethod());
//        8. setAttribute(key, value); 设置域数据
//        9. getAttribute(key); 获取域数据
//        10. getRequestDispatcher() 获取请求转发对象
        System.out.println("request.getAuthType() = " + request.getAuthType());
    }
}
