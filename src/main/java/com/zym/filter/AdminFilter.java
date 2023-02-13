package com.zym.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        String servletPath = httpServletRequest.getServletPath();  //获取客户端所请求的脚本文件的文件路径
        HttpSession session=httpServletRequest.getSession();
        if(httpServletRequest.getRequestURI().contains("demo")||httpServletRequest.getRequestURI().contains("getlogin")||httpServletRequest.getRequestURI().contains("login")||session.getAttribute("admin")!=null||httpServletRequest.getRequestURI().contains("test")||httpServletRequest.getRequestURI().contains("showTestAjax")||httpServletRequest.getRequestURI().contains("checkCode")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/getlogin");
            return;
        }

    }

    @Override
    public void destroy() {

    }
}
