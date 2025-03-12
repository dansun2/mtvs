package com.ohgiraffers.f_activity.lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationTests {

    @Test
    void calculate() {
        String result = Application.calculate("10, 20, 30"); // 클래스 내의 실제 존재하는 메서드 참조해야함

        // "합계: X, 평균: Y"
        // 합계: 60, 평균: 20
        Assertions.assertEquals("합계: 60, 평균: 20", result);
    }

    @Test
    void calculateNoSpaces() {
        String result = Application.calculate("5, 15, 25"); // 클래스 내의 실제 존재하는 메서드 참조해야함

        // "합계: X, 평균: Y"
        // 합계: 45, 평균: 15
        Assertions.assertTrue(result.contains("합계: 45"));
        Assertions.assertTrue(result.contains("평균: 15"));
    }
}
