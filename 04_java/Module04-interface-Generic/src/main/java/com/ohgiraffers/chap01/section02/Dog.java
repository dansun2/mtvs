package com.ohgiraffers.chap01.section02;

public class Dog extends Animal implements SoundMaker {
    @Override
    public void makeSound() {
        System.out.println("강아지 울음소리 멍멍! " + DECIBEL + "크기로 운다.");
    }
}
