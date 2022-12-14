package com.atguigu.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MangerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        Object user = request.getSession().getAttribute("user");
        if (user!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
