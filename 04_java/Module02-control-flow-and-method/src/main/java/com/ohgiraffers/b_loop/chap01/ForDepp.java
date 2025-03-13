package com.ohgiraffers.b_loop.chap01;
/*
* [for 문의 동작 메모리 구조]
* 1) for 문이 시작될 때, 반복 제어 변수(예: i, dan, num)은 스택에 생성된다.
* 2) 조건문이 참이면 본문을 실행하고, 증감식을 통해 변수 값을 변경한 뒤,
*   다시 조건을 검사하는 과정을 반복한다.
* 3) 반복 횟수가 끝나면 for 문의 스택 프레임은 제거되고, 다음 코드로 넘어간다.
*
* [성능 최적화 관점]
* 1) for 문은 초기식에서 변수를 한 번만 선언/계산하는 것이 좋다.
*   예) for(int i=0; i = arr.length; i++)
*   이렇게 하면 조건식에서 arr.length를 매번 호출하는 문제가 발생되기 때문에 아래와 같이 변경하는 것이 좋다.
*   int len = arr.length
*   for(int i=0; i = len; i++)
* 요새는 성능에 큰 영향을 주진 않는데 대용량 트래픽을 받거나 가독성을 생각하면 고려해야함
* just-in-time에 대해서 찾아보자.
* */
public class ForDepp {
}
