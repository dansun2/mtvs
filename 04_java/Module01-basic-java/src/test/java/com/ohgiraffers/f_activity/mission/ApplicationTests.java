package com.ohgiraffers.f_activity.mission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationTests {

    @Test
    void calculate() {
        String result = Application.calculate("Java is Fun");
        // 출력값
        // "단어1: 4, 단어2: 2, 단어3: 3, 총 길이: 9"
        Assertions.assertEquals("단어1: 4, 단어2: 2, 단어3: 3, 총 길이: 9", result);
    }
}
