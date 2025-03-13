package com.ohgiraffers.d_activity.mission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test // 입력한 값이 결괏값과 동일한지 확인
    void processNumbersValidInput() {

        Application application = new Application();

        // 1. 인풋값을 받고
        int input[] = {1, 3, 5, 8};

        // 2. 메서드를 실행시킨 결괏값(value) 확인
        String value = application.processNumber(input);

        // 예상값과 실행 결과값이 같은지 확인
        String result = "Monday, Wednesday, Friday, Unknown";
        Assertions.assertEquals(result, value);
    }

}