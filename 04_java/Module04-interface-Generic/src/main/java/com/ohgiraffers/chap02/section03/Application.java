package com.ohgiraffers.chap02.section03;
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

}
