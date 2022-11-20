package com.Servlet;

import com.bean.Person;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AjaxServlet extends BaseServlet{
    protected void js(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("js");
        Person person=new Person(1,"val1");

        Gson gson = new Gson();
        String s = gson.toJson(person);

        response.getWriter().write(s);
    }
    protected void jq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jq");
        System.out.println(request.getParameter("username"));
        Person person=new Person(1,"val1");

        Gson gson = new Gson();
        String s = gson.toJson(person);

        response.getWriter().write(s);
    }
}
