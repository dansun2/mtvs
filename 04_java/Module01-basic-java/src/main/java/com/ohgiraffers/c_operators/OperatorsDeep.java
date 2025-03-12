package com.ohgiraffers.c_operators;

public class OperatorsDeep {
    public static void main(String[] args) {
        /*
        * 1. 오버플로우(OverFlow)란?
        * 오버플로우는 정수형 데이터 타입이 표현할 수 있는 범위를 초과할 때 발생하는 현상이다.
        * 각 정수형 타입(int, short, byte)는 고정된 비트 수를 사용해서 값을 표현한다.
        * 예를 들어, 8비트의 byte 타입은 -128부터 127까지의 값을 가질 수 있다.
        * 이 범위를 초과하면 최솟값으로 돌아가고, 최솟값 미만으로 가면 다시 최대값으로 돌아가는 결과가 발생한다.
        * 이러한 오버플로우는 예기치 않은 결과를 초래할 수 있으므로, 프로그래밍 할 때 주의가 필요하다.
        * */

        int maxInt = Integer.MAX_VALUE;
        System.out.println("maxInt: " + maxInt);
        System.out.println("최대값 +1 : " + (maxInt + 1));
        maxInt = Integer.MIN_VALUE;
        System.out.println("최대값에 ++ 적용 : " + (++maxInt));

        /*
        * 2. 증감 연산자(++, --)와 실행 순서
        * 전위(++x)는 값이 먼저 변하고 연산에 사용된다.
        * 후위(x++)는 연산 후 값이 변한다.
        * 복잡한 식에서는 실행 순서가 결과를 좌우한다.
        * */
        int a = 5;
        int b = 5;
        int result1 = a++ + 2;
        int result2 = ++b + 2;
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);

    }
}
