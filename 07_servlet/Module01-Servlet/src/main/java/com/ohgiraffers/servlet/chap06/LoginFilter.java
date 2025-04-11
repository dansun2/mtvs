package com.ohgiraffers.servlet.chap06;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/auth/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        /*
        * auth로 시작하는 모든 요청을 처리하며
        * 해당 시점에 loggedInUser 값이 없는 경우 /chap04/index.html로 이동시킴
        * 세션을 생성하고 다시 확인하기
        * */
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/chap04/index.html");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
