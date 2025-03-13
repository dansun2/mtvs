package com.ohgiraffers.b_loop.chap02;
/*
* while 문
* while 문은 조건식이 true 인 동안 코드를 반복 실행한다.
* 형식 : while(조건식){실행 코드}
* 반복 횟수가 불확실하거나 조건에 따라 종료해야 할 때 유용하다.
* break 를 써주면 해당 스코프를 종료 시킬 수 있음
* 자식의 반복문에서 상위 반복문을 종료시키고 싶을때는 라벨링 하면 됨
* */
public class Application01 {
    public static void main(String[] args) {
        int count = 0;
        while (count < 5) {
            System.out.println("카운트 : " + count);
            count++;
        }
    }
}
