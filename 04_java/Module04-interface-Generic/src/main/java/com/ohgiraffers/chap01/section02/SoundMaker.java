package com.ohgiraffers.chap01.section02;
/*
* 인터페이스
*
* 인터페이스는 클래스가 구현해야 하는 메서드의 집합을 정의하는 계약이다.
* 인터페이스에 정의된 모든 메서드는 기본적으로 추상 메서드이며, 구현부가 없다.
* 이를 구현하는 클래스는 인터페이스에 정의된 모든 메서드를 반드시 구현해야 한다.
*
* 인터페이스는 다음과 같은 특징을 갖는다.
* 1. 메서드는 자동으로 public 과 abstract 로 간주된다.
* 2. 필드는 자동으로 public static final 로 간주되어 상수로 취급된다.
* 3. 다중 상속을 지원하며 여러 인터페이스를 구현할 수 있다.
* 4. 서로 다른 클래스 간의 공통된 기능을 정의하여 코드의 재사용성을 높인다.
* */
public interface SoundMaker {
    int DECIBEL = 5;
    void makeSound();
}
