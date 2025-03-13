package com.ohgiraffers.c_method.chap01;
/*
* 메서드의 종류
*
* 1. 정적 메서드 (static method)
*   클래스에 속하며, 객체 생성없이 호출할 수 있다.
*
* 2. 인스턴스 메서드 (instance method)
*   객체에 속하며, 객체를 생성한 후 호출해야 한다.
*
* 3. 생성자 (constructor)
*   클래스의 인스턴스를 생성할 때 호출되는 특별한 메서드이다.
*   생성자의 경우 반환 타입은 없고 클래스의 이름과 동일하다.
*
* 4. 오버로딩 (method overloading)
*   같은 이름의 메서드를 여러 개 정의하되, 매개변수의 타입이나 개수(시그니처)를 다르게 사용한다.
* */
public class Application02 {
    public static void main(String[] args) {
        Application02Method application02 = new Application02Method(); // 인스턴스 생성

        System.out.println(application02.instanceMethod());

        Application02Method.getGreeting(); // static은 프로그램이 실행되면서 이미 올라가 있어서 인스턴스를 생성할 필요 X

        System.out.println(application02.overloadedMethod());
        System.out.println(application02.overloadedMethod("hello"));
    }
}
