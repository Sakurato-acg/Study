package com.itheima.web;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebServlet(urlPatterns = "/demo1", loadOnStartup = 1)
public class ServletDemo1 implements Servlet {

    public ServletDemo1() {
        System.out.println("1 构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init 初始化");
        System.out.println("servletConfig.getServletName() = " + servletConfig.getServletName());
        System.out.println("servletConfig.getInitParameter(\"username\") = " + servletConfig.getInitParameter("username"));
        System.out.println("servletConfig.getServletContext() = " + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        if (method.equals("POST")) {
            dopost();
        } else if (method.equals("GET")) {
            doget();
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy");
    }

    public void doget() {
        System.out.println("GET请求");

    }

    public void dopost() {
        System.out.println("POST请求");

    }
}
