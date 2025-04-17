package com.ohgiraffers.interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//일반적으로 시간초체크는 filter 단에서 이루어짐 interceptor가 아니라. 지금은 전처리 후처리를 보여주기 위해 실습용으로 넣음
@Component
public class StopWatchInterceptor implements HandlerInterceptor {
    private final MenuService menuService;

    public StopWatchInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }

    // 전처리 메서드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandler 호출함...");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    // 후처리 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("posthandler 호출함...");
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");

        long endTime = System.currentTimeMillis();
        modelAndView.addObject("interval", endTime-startTime);
    }

    // 마지막에 호출하는 메서드 -> 주로 리소스 제거에 많이 사용하고 필요없으면 굳이 안써도 됨
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("after completion 호출함...");
        menuService.method();
    }
}
