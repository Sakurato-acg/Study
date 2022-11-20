package com;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("前2");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("后2");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
