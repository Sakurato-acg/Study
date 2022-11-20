package com;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean aNew = session.isNew();
        String id = session.getId();
        response.getWriter().write("Session的ID是"+id+" <br /> ");
        response.getWriter().write("Session是新建的吗"+aNew+" <br /> ");
    }

    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("key1","value1");
        response.getWriter().write("set了");

    }
    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object key1 = request.getSession().getAttribute("key1");
        response.getWriter().write("get="+key1);
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().setMaxInactiveInterval(20);
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("Session的默认超时时长为:"+maxInactiveInterval+"秒");
    }
    protected void life3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setMaxInactiveInterval(3);
        int maxInactiveInterval = session.getMaxInactiveInterval();
        response.getWriter().write("Session3秒超时销毁="+maxInactiveInterval);
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.getWriter().write("马上无效");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
