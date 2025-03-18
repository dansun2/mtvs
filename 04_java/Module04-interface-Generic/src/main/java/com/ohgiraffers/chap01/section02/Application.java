package com.ohgiraffers.chap01.section02;
/*
* 인터페이스란?
* - 특정 관점(기능)을 독립적으로 정의한 규칙이다.
* - `interface`로 선언, 구현은 클래스에서 이루어짐
*
* 인터페이스로 상속 문제 해결
* - Animal 은 기본 동물 정의, 울음소리는 SoundMaker 로 분리
* - 강아지, 고양이는 SoundMaker 구현, 뱀은 안 함.
* 결과 : 울음소리 없는 뱀
* */
public class Application {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Snake()};

        System.out.println("동물 중 울 수 있는 녀석은 울어~");
        /*
        * 캐스팅 이해
        * 업캐스팅 :
        *   자식 클래스의 객체를 부모 클래스로 변환하는 과정
        *   자식의 기능을 접근할 수 없으나 부모에게 ㅁ줄려받은 기능은 접근 가능
        *   dog -> animal
        * 다운캐스팅 :
        *   부모 클래스 타입의 객체를 자식 클래스 타입으로 변환하는 과정
        *   이 경우, 해당 객체가 실제로 자식 클래스의 인스턴스일 때만 가능
        *   Animal animal = new Dog();
        *   (Dog) animal;
        * */
        for (Animal animal : animals) {
            if (animal instanceof SoundMaker) { // 좌항 타입이 우항과 같은지
                System.out.println();
                ((SoundMaker) animal).makeSound(); // 형변환
            } else {
                System.out.println("울음소리가 없는 동물이네요.");
            }
        }
    }
}
