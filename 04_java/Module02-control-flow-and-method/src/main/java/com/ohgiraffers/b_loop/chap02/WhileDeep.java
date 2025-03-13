package com.ohgiraffers.b_loop.chap02;
/*
* while 문 동작의 메모리 구조
* 1) while 문이 시작될 떄, 조건식에 사용되는 변수 예: count, limit 는 스택에 생성된다.
* 2) 조건식이 참이면 본문을 실행하고, 조건을 다시 검사하며 반복한다.
* 3) 조건이 거짓이 되면 while 문의 스택 프레임이 제거되고 종료된다.
*
* [성능 최적화]
* 1) 조건식 계산을 최소화 하면 성능이 향상된다.
*   예) while(count <= limit) {...} 과 같이 상수값을 활용할 수 있다.
*
* 2) 비최적화된 경우, 반복마다 조건에 메서드를 호출하여 결과를 확인하는 경우 성능 저하 발생
* 3) 무한 루프(while(true))는 스택 오버플로우를 유발할 수 있으니 break 사용 권장
* 4) jit 컴파일러 루프 언롤링(unrolling)으로 최적화 가능
* */
public class WhileDeep {
    public static void main(String[] args) {
        // 1. 비회적화 while 문 : 조건식에서 매번 계산
        System.out.println("1. 비최적화 while");
        long startTime = System.nanoTime();
        int count = 0;
        while (count <= counter()){
            System.out.println("비최적화 카운트 : " + count);
            count++;
        }
        long endTime = System.nanoTime();
        System.out.println("실행 시간 : " + (endTime - startTime));

        // 2. 최적화
        System.out.println("2. 최적화 while");
        startTime = System.nanoTime();
        count = 0;
        int result = counter();
        while (count <= result){
            System.out.println("최적화 카운트 : " + result);
            count++;
        }

        System.out.println("실행시간 : " + (endTime - startTime));
    }
    private static int counter(){
        return "안녕하세요~~~~~".length();
    }
}
