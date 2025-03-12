package com.ohgiraffers.c_operators;

/*
* 연산자(Operators)
*
* 산술 연산자
*  수학적 계산을 수행하는 연산자이다.
* + (덧셈), - (뺄셈), * (곱셈), / (나눗셈), % (나머지)
*
* 비교 연산자
*  두 값을 비교하여 참(true) 또는 거짓(false)를 반환하는 연산자이다.
* == 같음, != 같지 않음, < 작음, > 큼, <= 작거나 같음, >= 크거나 같음
*
* 논리 연산자
*  하나 이상의 조건을 결합하여 최종적인 참 또는 거짓을 평가하는 연산자이다.
* && (and), || (or), ! (not)
*
* 대입 연산자
*  변수에 값을 할당하는 연산자
* = (대입), += (덧셈 후 대입), -= (뺄셈 후 대입), *= (곱셈 후 대입), /= (나눗셈 후 대입)
*
* 증감 연산자
* ++ 증가, -- 감소
* */
public class Application {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println("덧셈: " + (a + b));
        System.out.println("나눗셈: " + (a / b));  // 정수 나눗셈 (소수점 이하 버려짐)
        System.out.println("나머지: " + (a % b));

        boolean isGreater = a > b;
        System.out.println("a가 b보다 큰가? " + isGreater);

        /*
         *  논리 연산자
         */
        boolean isTrue = true;
        boolean isFalse = false;
        System.out.println("둘 다 참인가? : " + (isTrue && isFalse));
        System.out.println("둘 중 하나가 거짓인가? : " + (isTrue || isFalse));
        System.out.println("NOT은 너가 거짓이라는 것을 부정 하겠어!! : "+!isFalse);

        /*증감 연산자*/
        int age = 20;
        System.out.println("세월이 지나면 ~~~ :  " + (++age));
        System.out.println("작년에는 말이야.. : " + (--age));
    }
}
