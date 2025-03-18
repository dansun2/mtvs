package com.ohgiraffers.chap02.section03;

import com.ohgiraffers.chap02.section03.model.*;

/*
* 와일드카드란?
* - 제네릭스에서 :어떤 타입:을 유연하게 다루는 방법
* - 문법
*   <? extends 타입> : 그 타입과 그 아래만 허용 (꺼내기 쉬움)
*   <? super 타입> : 그 타입과 그 위만 허용 (넣기 쉬움)
*
* 설계 과정
* 1) 기본 상자
*   - FoxBox<Apple>는 사과만 담음 -> 다른 과일 다루려면 유연성 부족
* 2) extends 로 꺼내기
*   - <? extends Fruit> : 과일과 그 하위 (사과, 포도) 꺼내기 가능
* 3) super 로 넣기
*   - <? super Apple> : 사과를 과일 상자에 넣기 가능
* */
public class Application {
    public static void main(String[] args) {
        System.out.println("기본 상자");
        FoodBox<Apple> appleBox = new FoodBox<>(); // FoodBox로 Apple타입의 객체를 담는 상자를 만듦

        // 만든 객체에 item을 넣어줌 -> super클래스인 Food필드의 name = 애쁠
        // 여기서 setItem("애쁠")을 바로 넣을 수 없는 이유는
        // appleBox는 Apple 클래스 타입이 들어와야 하고 "애쁠"은 String 타입이다 => 타입불일치
        appleBox.setItem(new Apple("애쁠"));

        // System.out.println은 인자로 넘겨받은 객체를 출력함
        // Food 클래스에 toString() 메서드가 있어서 출력됨
        System.out.println("꺼낸 물건 : " + appleBox.getItem());

        System.out.println("와일드 카드 넣기 ");
        FoodBox<Food> fruitBox = new FoodBox<>();
        putApple(fruitBox, new Apple("Apple"));
        // --
        FoodBox<Grape> grapeBox = new FoodBox<>();
        // putApple(grapeBox, new Apple("12"));
        
    }

    private static void showFruit(FoodBox<? extends Fruit> box) {
        Fruit fruit = box.getItem();
        System.out.println("꺼낸 과일 : " + fruit);
        
        // 꺼내는 쪽에서는 꺼내는것만 가능
        // box.setItem(new Apple("hello"));
        /*
        * box는 FoodBox<? extends Fruit>로 정의되어 있어
        * 어떤 특정 서브타입(FoodBox<Apple>, FoodBox<Banana>등)인지 컴파일러가 알 수 없다.
        * showFruit를 호출하는 것을 보면 "포도 박스", "사과 박스"가 매개변수로 전달된다.
        * 
        * 따라서 box에 Apple를 넣는 것은 타입의 불일치를 초래할 수 있기 때문에
        * 컴파일러는 이를 안전하지 않다고 판단하여 오류를 발생시키는 것이다.
        * 꺼내는 것은 안전하지만(모든 서브타입은 Fruit으로 처리가 가능), 넣는 것은 허용하지 않는다.
        * */
    }

    
    private static void putApple(FoodBox<? super Apple> box, Apple apple) {
        box.setItem(apple);
        // 넣는 쪽에서는 넣는것만 가능
        // Apple fruit = box.getItem();
        /*
        * 꺼낼 수 없는 이유
        * - box는 FoodBox<? super Apple>로 정의되어 있어, Apple의 상위 타입을 허용한다.
        * - 따라서 box에 들어 있는 객체는 Apple이 아닐 수도 있다.
        *   예를 들어, Fruit 또는 Object 타입이 들어갈 수 있다는 것이다.
        * - get() 메서드 호출 시 반환되는 타입이 보장되지 않기 때문에 이를 Apple로 직접 캐스팅하는것이 안전하지 않다.
        * - 타입 안전성을 보장하기 위해 컴파일러는 오류를 발생시킨다.
        * 
        * 즉, box에 타입 제한이 Apple의 상위 타입이기 때문에, Apple만 들어있다는 보장이 불가능하다.
        * */
        
        /*
        * PECS 원칙 (Producer Extends, Consumer Super)
        * - 꺼내는(Producer) 경우 extend, 넣는(Consumer) 경우 super 를 뜻한다
        * - PECS 이해 : 
        *   - <? extends T> (Producer) : T와 그 하위 타입에서 "꺼내기"만 가능 -> 읽기 안전성 보장
        *       예: <? extends Fruit>는 Fruit 상자에서 사과나 포도 꺼내기 OK, 넣기는 불가
        *   - <? super T> (Consumer) : T와 그 상위 타입에서 "넣기"만 가능 -> 쓰기 유연성 확보
        *       예: <? super Apple>는 Apple 을 Fruit 상자에 넣기 OK, 꺼내면 무엇이 나올지 모름
        * */
    }
}
