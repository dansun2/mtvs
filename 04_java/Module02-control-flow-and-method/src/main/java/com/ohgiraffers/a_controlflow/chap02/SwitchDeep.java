package com.ohgiraffers.a_controlflow.chap02;
/*
* switch 문의 깊은 개념
* switch 는 jvm에서 jump table로 컴파일되어 if-else보다 빠를 수 있다.
* - 식의 값은 스택에 저장, case 레이블은 메서드 영역의 상수 풀과 비교.
* - break가 없는 경우 fall-through 로 연속 실행
* 
* jump table:
* swtich 문을 효율적으로 구현하기 위한 기법 중 하나로 이는 특정 값에 대한 경로를 빠르게 찾기 위해서이다.
* 각 case "결과 값"의 실행 코드 주소를 저장한 테이블을 사용한다.
* ex) switch(2):
*       case 1: print(1);
*       case 2: print(2); <---- 식의 값이 2로 2번의 인덱스를 참조해서 바로 실행
*
* jdk 17 개선
* - switch 표현식 case -> 으로 변환
* - 패턴 매칭 객체 타입으로 분기 가능
* */
public class SwitchDeep {
    public static void main(String[] args) {
        int day = 3;
        String result = switch (day) {
            // 람다 표현식 다시 한 번 보기
            case 1 -> "월요일";
            case 2 -> "화요일";
//            case 3 -> System.out.println("수요일");
            case 4 -> {
                System.out.println("목요일");
                yield "목요일";
            }
            case 5,6,7 -> "주말";
            default -> "기타";
        };
    }
}
