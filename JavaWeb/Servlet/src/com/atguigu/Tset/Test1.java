package com.atguigu.Tset;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class Test1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("Test<1>"+username);

        request.setAttribute("key","柜台1");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/a.html");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
