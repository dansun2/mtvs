package com.ohgiraffers.oop.chap03.section02.deep.mission01;

import com.ohgiraffers.oop.chap03.section02.deep.mission01.animals.Dog;

/*
* jvm 관점에서 상속
* - 부모-자식 객체는 힙에 함께 저장 ***
* - 자식의 객체는 부모 필드를 포함한다.
* - 메서드 테이블(vtable) : 오버라이드 시 동적 바인딩으로 약간 느려질 수 있다.
* - GC : 상속 계층이 깊으면 객체의 크기가 커져 GC의 부하가 발생할 수 있다.
* */
public class Application {
    public static void main(String[] args) {
        Dog dog = new Dog("모카",12, "말티즈");
        dog.printInfo();
        dog.bark();

    }
}
