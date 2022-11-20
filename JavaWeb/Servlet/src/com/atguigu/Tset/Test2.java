package com.atguigu.Tset;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class Test2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("Test<2>"+username);

        Object key = request.getAttribute("key");
        System.out.println("key = " + key);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
