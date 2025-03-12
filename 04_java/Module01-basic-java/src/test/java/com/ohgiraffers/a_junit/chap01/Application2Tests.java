package com.ohgiraffers.a_junit.chap01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Application2Tests {

    @Test
    public void test() {
        int result = 3 + 2;
        /*
        * assertEquals(expected, actual, [message])
        * - 예상값 (expected)와 실제값 (actual)이 같은지 확인
        * - 같지 않다면 AssertionError 발생
        * - 세 번째 인수로 메세지를 넣어 실패를 출력한다.
        * */
        Assertions.assertEquals(5,result,"3+2는 5여야 합니다.");
    }

    @Test
    public void test2() {
        boolean condition = 10 > 7;
        /*
        * assertTrue(condition,[message])
        * 주어진 조건이 true인지 확인한다.
        * false면 AssertionError 발생
        * */
        Assertions.assertTrue(condition, "10은 7보다 커야 합니다.");
        Assertions.assertFalse(!condition, "10은 7보다 커야 합니다.");
    }
}
