package com.ohgiraffers.junit;

import com.ohgiraffers.oop.chap01.basic.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTests {
    private Car car;


    // 테스트코드는 순서가 보장되지 않음. 그래서 순서를 주려고 하면 @Order(n) 를 써서 실행 순서를 보장해줌.

    // db커넥션
    // 커넥션풀 검색->네트웍비용때문
    // 미리 커넥션 맺어놓은 객체를 씀.
    // db세션

    /*
    * @BeforeEach 란?
    * - 각 테스트 메서드 실행 전 *마다* 호출되는 설정 메서드
    * - 역할 : 테스트 환경 초기화 (예 : 객체 생성, 데이터 준비)
    * - 비유 : 계산기 테스트 전에 새 계산기를 꺼내는 것과 같다.
    * */
    @BeforeEach
    void setUp () {
        this.car = new Car();
        this.car.brand = "Tesla";
        this.car.model = "Model S";
        System.out.println("테스트를 위한 자동차가 준비 되었습니다.");
    }

    @Test
    void testSpeed() {
        this.car.accelerate();
    }

    /*
    * @AfterEach
    * - 각 테스트 메서드 실행 후 *마다* 호출되는 정리 메서드
    * - 역할 : 테스트 후 자원 해제나 상태 초기화
    * - 비유 : 계산기 테스트 끝나면 버튼 초기화하거나 치우는 것
    * */
    @AfterEach
    void tearDown(){
        this.car = null;
        System.out.println("테스트가 종료되어 자동차를 정리합니다.");
    }
}
