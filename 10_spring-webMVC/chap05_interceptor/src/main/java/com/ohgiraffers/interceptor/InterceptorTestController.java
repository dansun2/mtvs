package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InterceptorTestController {

    @GetMapping("stopwatch")
    public String stopwatch() throws InterruptedException {
        System.out.println("핸들러 메소드 호출함...");
        Thread.sleep(1000); // 쓰레드를 1초동안 멈추도록 만듦 -> 쓰레드가 병목
        return "result";
    }
}
