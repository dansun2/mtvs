package com.ohgiraffers.a_basic;

/*
* java의 기본 구조 및 실행 방식
*
* 자바는 클래스를 기반으로 프로그램을 작성하는 객체 지향 프로그래밍 언어이다.
* 모든 java 프로그램은 클래스 안에서 동작하며, main() 메서드가 프로그램의 시작점이 된다.
*
* java의 실행 과정
*   1. java 소스 코드(.java)를 작성한다.
*   2. 컴파일러(javac)를 사용하여 바이트 코드(.class)로 변환한다.
*   3. jvm이 class 파일을 실행한다.
*   4. jvm은 바이트 코드를 해석하여 os에서 실행 가능한 기계어로 변환한다.
*   5. 실행 결과를 출력하거나 다른 연산을 수행한다.
*
* java의 실행 방식은 컴파일 + 인터프리터 방식을 사용한다.
* 이는 java 코드가 먼저 바이트 코드로 변환된 후 jvm에 의해 해석 실행되는 것을 의미한다.
*
* - 컴파일: .java -> .class 로 변환되는 과정 (jvm이 이해하기 위함.)
* - 바이트 코드(.class) : jvm에서 실행 가능한 중간 코드
* - jvm : 바이트코드를 OS에 맞는 기계어로 변환하여 실행
* - JIT(just -in -time) 컴파일러 : 실행 중 바이트 코드를 네이티브 코드로 변환하여 성능 향상
*                               -> 내부적으로 성능 최적화를 위해 사용 -> 내부적으로 연산 횟수를 줄임
* */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
