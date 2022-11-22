package com.yj.springboot_mix.config.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 请求方法拦截
 */
public class RequestMethodFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =  (HttpServletRequest) servletRequest;
        HttpServletResponse response =  (HttpServletResponse) servletResponse;
        if(request.getMethod().equalsIgnoreCase("GET")
                || request.getMethod().equalsIgnoreCase("POST")){
            filterChain.doFilter(servletRequest , servletResponse);
        }else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("only support GET or POST ");
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
