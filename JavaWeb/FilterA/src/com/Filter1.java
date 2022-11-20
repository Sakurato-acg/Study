package com;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("前1");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("后1");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
