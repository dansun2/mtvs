package com.ohgiraffers.chap02.section03;

import com.ohgiraffers.chap02.section03.model.*;

/*
* 와일드카드란?
* - 제네릭스에서 :어떤 타입:을 유연하게 다루는 방법
* - 문법
*   <? extends "타입"> : 그 "타입"과 그 아래만 허용 (꺼내기 쉬움)
*   <? super "타입"> : 그 "타입"과 그 위만 허용 (넣기 쉬움)
*
* 설계 과정
* 1) 기본 상자
*   - FoodBox<Apple>는 사과만 담음 -> 다른 과일 다루려면 유연성 부족
* 2) extends 로 꺼내기
*   - <? extends Fruit> : 과일과 그 하위 (사과, 포도) 꺼내기 가능
* 3) super 로 넣기
*   - <? super Apple> : 사과를 과일 상자에 넣기 가능
* */
public class Application {
    public static void main(String[] args) {
        System.out.println("기본 상자");
        FoodBox<Apple> appleBox = new FoodBox<>(); // FoodBox로 사과의 형태만(Apple) 담는 상자를 만듦

        // 만든 객체에 item을 넣어줌 -> super클래스인 Food필드의 name = 애쁠
        // 여기서 setItem("애쁠")을 바로 넣을 수 없는 이유는
        // appleBox는 Apple 클래스 타입이 들어와야 하고 "애쁠"은 String 타입이다 => 타입불일치
        appleBox.setItem(new Apple("애쁠"));

        // System.out.println은 인자로 넘겨받은 객체를 출력함
        // Food 클래스에 toString() 메서드가 있어서 출력됨
        System.out.println("꺼낸 물건 : " + appleBox.getItem());

        System.out.println("와일드 카드 넣기 ");

        // FoodBox 형식의 반환타입 Food를 갖고 있는 객체 생성 -> Food는 조부모
        // Apple나 Grape 같은 하위 클래스의 객체가 들어있더라도 반환 타입은 Food
        FoodBox<Food> fruitBox = new FoodBox<>();
        putApple(fruitBox, new Apple("사과"));
        System.out.println(fruitBox.getItem());
        
        FoodBox<Grape> grapeBox = new FoodBox<>();
        // putApple(grapeBox, new Apple("12"));
        
    }

    // set은 안되는 이유
    // Fruit나 Fruit를 상속받고 있는 클래스중에 꺼내는것만 가능한데 -> Apple도 Fruit이고 Grape도 Fruit니까 상위 클래스인 Fruit 타입으로 받을 수 있음
    // -> 이 박스에 들어있는게 최소한 Fruit의 하위 타입이라는 걸 컴파일러가 보장하기 때문에 꺼내는것을 허용
    // 만약 set을 넣게 되면 Apple박스에 포도를 넣는 일이 생김 -> 타입 불일치로 런타임 에러를 발생 시킬 수 있어서 컴파일러가 막음
    // 도서관 책장이라고 생각해라. 과학책, 소설책, 철학책이 있는데 꺼내 읽는 것은 상관이 없음.
    // 그러나 새 책을 꽂는건 소설책 책장인지 과학책 책장인지 모르기 때문에 허용안됨
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

    // get은 안되는 이유
    // 큰 창고에서 사과를 꺼내야 하는데 불이 꺼져있음 -> 창고가 Apple 창고인지 Fruit 창고인지 Food 창고인지 모름
    // Fruit 창고면 Fruit 타입이 들어있을 수 있고, Food 창고면 Food 타입이 들어있을 수 있다. => 그래서 Object로만 꺼낼 수 있음
    // Apple 포함 Apple의 상위클래스 어떤 것에 넣어도 Apple이 Fruit과 Food에 속해 있는 것은 변함이 없다 (Fruit과 Food의 일부이기 때문)
    // => Apple, Fruit, Food 중 어떤 박스에 Apple을 넣어도 상위 타입의 규칙을 깨지 않음.
    private static void putApple(FoodBox<? super Apple> box, Apple apple) {
        box.setItem(apple);
        // 넣는 쪽에서는 넣는것만 가능
        // Apple fruit = box.getItem(); 은 안 됨
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
