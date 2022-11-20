package com.atguigu.Response_;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class Response2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html;Charset=UTF-8");

        response.getWriter().write("安顺达斯柯达卡萨");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
