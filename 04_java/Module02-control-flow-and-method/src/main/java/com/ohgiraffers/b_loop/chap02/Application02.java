package com.ohgiraffers.b_loop.chap02;
/*
* while 문 응용
* while 문을 사용해 사용자 입력 기반 반복이나 조건 기반 종료를 구현할 수 있다.
* 예 : 0이 될 때까지 숫자 감소
*
* while 문 제어 키워드
* - break; 반복문을 즉시 종료하고 빠져나간다.
* - continue : 현재 반복을 건너뛰고 다음 반복으로 진행한다.
* */
public class Application02 {
    public static void main(String[] args) {
        // 용사의 모험
        int hp = 5;
        System.out.println("용사의 모험 시작 : 몬스터를 물리치고 보물을 찾아라");
        System.out.println("현재 용사의 체력은 : " + hp + "이다.");
        int i = 1;
        while(hp>0) {

            System.out.println(i + "회");
            i++;
            // continue
            if (hp % 2 == 0) {
                System.out.println("독 늪지에 빠지게 되었다. 체력 회복이 우선이니 이번 전투는 다음으로 미룬다");
                hp--;
                continue;
            }

            System.out.println("마왕 이준혁과 전투가 시작되었다." + hp + "로 전투 승리");

            if (hp == 3) {
                System.out.println("축하합니다. 체력 3의 행운으로 보물 상자를 발견하였습니다.");
//                break;
            }

            hp--;
        }
    }
}
