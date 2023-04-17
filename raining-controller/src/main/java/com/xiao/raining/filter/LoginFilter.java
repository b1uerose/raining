package com.xiao.raining.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录过滤器
 * Author: xiaojl
 * Date:2023-04-16 16:39
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        boolean isLoginSuccess = isLoginSuccess(httpServletRequest, httpServletResponse);
        if (!isLoginSuccess) {
            ((HttpServletResponse)response).sendRedirect(httpServletRequest.getContextPath() +"/ui/login/Login.jsp");
            return;
        }
        chain.doFilter(request, response);
    }
    
    private boolean isLoginSuccess( HttpServletRequest httpServletRequest, HttpServletResponse response) {
        HttpSession session = httpServletRequest.getSession(false);
        if (session != null) {
            Boolean isLogin = (Boolean) session.getAttribute("isLogin");
            if (isLogin != null && isLogin) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
