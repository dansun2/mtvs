package com.ohgiraffers.oop.chap04.section02;

public class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(super.name + "가 울음소리를 냅니다. 야옹~");
    }

}
