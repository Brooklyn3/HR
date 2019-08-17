package com.qfedu.hr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证过滤器
 *
 * @author ZZzz
 */
//@WebFilter("/*")
public class CLoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取用户访问的资源名称s
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();

        //与登录相关的资源不应该被过滤，可以允许用户之间访问
        if (requestURI.contains("/fontd/") || requestURI.contains("LoginServlet") || requestURI.contains("checkCodeServlet") || requestURI.contains("login") || requestURI.contains("index") || requestURI.contains("/css/") || requestURI.contains("/js/") || requestURI.contains("/img/")) {
            chain.doFilter(servletRequest, servletResponse);
        } else if (null == session || session.getAttribute("user") == null) {
            //没有session信息，或者说用户没有登录
            response.sendRedirect("login.jsp");
        } else if (session != null && session.getAttribute("user") != null) {
            //访问的不是登录资源，并且在服务器上已经存在登录记录，直接放行
            chain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
