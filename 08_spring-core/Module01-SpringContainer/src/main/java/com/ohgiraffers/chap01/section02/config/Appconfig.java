package com.ohgiraffers.chap01.section02.config;

import com.ohgiraffers.chap01.section02.service.KakaoPayGateway;
import com.ohgiraffers.chap01.section02.service.NaverPayGateway;
import com.ohgiraffers.chap01.section02.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
*
* */
@Configuration
public class Appconfig {

    @Bean
    public KakaoPayGateway kakaoPayGateway() {
        return new KakaoPayGateway();
    }

    @Bean
    public NaverPayGateway naverPayGateway() {
        return new NaverPayGateway();
    }

    @Bean()
    public PaymentService paymentService() {
        return new PaymentService(kakaoPayGateway());
    }
}
