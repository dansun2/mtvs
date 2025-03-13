package com.ohgiraffers.a_controlflow.chap02;
/*
* switch 문
* switch 문은 변수나 식의 값에 따라 실행 경로를 선택하는 제어문이다.
* 형식 : switch (식) { case 값 : 코드; break; default : 기본 코드}
*
* - 식 : 정수, 문자열, 열거형(enum) 등 비교 가능한 타입
* - case : 특정 값과 비교하여 해당 값이 일치할 때 실행할 코드를 정의
*   - 여러 개의 case 를 정의하여 다양한 값에 대한 분기를 처리할 수 있으며,
*   - case 값은 고유해야 하며 중복되지 않아야 한다.
*   - case 값이 일치하면 그 다음에 오는 실행 코드가 실행되고, 이후 break 문을 만나면 switch 블록을 빠져나간다.
* - break; 분기를 종료하고 switch 블록을 빠져나감(누락 시 fall-through)
* - default : 모든 case 와 일치하지 않을 때 실행되는 코드 블록,
* 다중 if-else를 대체하며, 값 기반 분기에 적합하다.
*
* fall-through
* switch 문에서 특정 case 블록의 실행이 끝난 후 break 문 없이 다음 case 로 넘어가는 현상
* */
public class Application01 {
    public static void main(String[] args) {
        int month = 3;
        switch (month) {
            case 1:
                System.out.println("1월");
                break;
            case 2:
                System.out.println("2월");
                break;
            case 3:
                System.out.println("3월");
                break;
            default:
                System.out.println("그 외 달");
        }
    }
}
