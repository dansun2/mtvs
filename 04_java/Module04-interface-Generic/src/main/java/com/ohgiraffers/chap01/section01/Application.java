package com.ohgiraffers.chap01.section01;
/*
* 상속만 사용할 때 문제
* - 동물(Animal)을 상속받아 강아지, 고양이, 뱀을 구현하면,
*   모든 동물에 울음소리가 있다고 가정했을 때, 뱀은 울지 않는데 억지로 물려받게 된다. -> 불필요한 기능 강요
* - 문제 : 상속은 "모든 기능"을 물려주기 때문에 관점(울음소리) 분리 불가.
* */
public class Application {
    public static void main(String[] args) {
        Animal animals[] = {new Dog(), new Cat(), new Snake()};

        System.out.println("동물들아 울음소리를 보여줘~");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
