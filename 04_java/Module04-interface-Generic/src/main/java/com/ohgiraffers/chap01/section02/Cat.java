package com.ohgiraffers.chap01.section02;

public class Cat extends Animal implements SoundMaker {
    @Override
    public void makeSound() {
        System.out.println("고양이 울음소리 야옹~" + DECIBEL + " 크기로 울음소리를 낸다.");
    }
}
