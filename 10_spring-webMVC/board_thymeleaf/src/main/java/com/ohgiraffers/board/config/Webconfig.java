package com.ohgiraffers.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class Webconfig {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() { // http 요청이 get,post 두 개 밖에 못받으므로 _method= 의 진짜 타입을 con에 매핑시킴
        return new HiddenHttpMethodFilter();
    }
}
