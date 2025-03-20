package com.ohgiraffers.exception.section01;
/*
* 예외 처리 미사용
* - 예외 처리를 하지 않으면, 프로그램 실행 중 발생한 예외로 인해 프로그램이 비정상적으로 종료될 수 있다.
* - 예를 들어, 사용자가 0으로 나누기를 시도하면 프로그램이 즉시 종료되며, 사용자에게 아무런 안내도 제공하지 않는다.
*
* 예외 처리가 필요한 이유
* - 예외가 발생하면 프로그램이 비정상적으로 종료됨.
* - 안정적인 프로그램 실행을 위해 반드시 처리해야 된다.
*
* 실생활 비유
* - 예외 처리를 하지 않는 것은 요리 중 불이 꺼졌을 때 아무런 조치를 취하지 않고 요리를 계속 진행하는 것과 같다.
*   이 경우, 요리는 망치고 주방도 엉망이 될 수 있다.
* */
public class Application {
    public static void main(String[] args) {
        int number = 10;
        int result = number/0;
        System.out.println("결과 : " + result);
    }
}
