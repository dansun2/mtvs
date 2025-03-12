package com.ohgiraffers.d_arrays;

public class Application {
    public static void main(String[] args) {
        /*
        * 배열
        * 배열은 동일한 데이터 타입의 요소를 연속적으로 저장하는 자료구조이다.
        * 선언 : 타입[] 변수명 = new 타입[크기];
        *
        * 인덱스(0부터 시작)를 사용해 요소에 접근한다.
        * 배열은 고정된 크기를 가지며, 생성 후 크기 변경이 불가능하다.
        * 배열의 길이는 length 속성을 사용하여 확인할 수 있다.
        *
        * 예시
        * int[] numbers = {1,2,3,4,5,6};
        * */

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(numbers[0]);
        numbers[0] = 100;
        System.out.println(numbers[0]);
        System.out.println(numbers.length);
        int[] numbers2 = new int[numbers.length];
        numbers2 = numbers;
        System.out.println(numbers2);
    }
}
