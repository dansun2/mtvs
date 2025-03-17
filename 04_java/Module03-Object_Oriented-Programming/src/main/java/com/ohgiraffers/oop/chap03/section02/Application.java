package com.ohgiraffers.oop.chap03.section02;

public class Application {
    public static void main(String[] args) {

        Dog dog = new Dog("바둑이");
        dog.makeSound();

        Animal animal = new Animal("동물");
        animal.makeSound();

        animal = dog;
        animal.makeSound(); // 부모에게 있는 기능이라 비활성화가 되지 않고 치환됨
    }
}
