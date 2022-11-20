package com;

import com.util.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CookieServlet extends BaseServlet {
    protected void path(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
// getContextPath() ===>>>> 得到工程路径
        cookie.setPath(request.getContextPath() + "/abc"); // ===>>>> /工程路径/abc
        response.addCookie(cookie);
        response.getWriter().write("创建了一个带有 Path 路径的 Cookie");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        Cookie cc = CookieUtils.findCookie("key1", cookies);
        response.getWriter().write(cc.getValue());

    }

    protected void creatCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2. 通过客户端保存Cookie
        response.addCookie(cookie);

        response.getWriter().write("Cookie创建成功");
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //方案一
//        Cookie cookie=new Cookie("key1","newValue1");
//        response.addCookie(cookie);
//        response.getWriter().write(cookie.getName()+"--"+cookie.getValue());
        //方案2
        Cookie[] cookies = request.getCookies();
        Cookie cc = CookieUtils.findCookie("key1", cookies);
        cc.setValue("意义");

        response.addCookie(cc);
        response.getWriter().write(cc.getValue());

    }
}
