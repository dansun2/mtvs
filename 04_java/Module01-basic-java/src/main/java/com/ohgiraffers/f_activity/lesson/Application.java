package com.ohgiraffers.f_activity.lesson;

public class Application {
    public static void main(String[] args) {
        String numText = "10, 20, 30";
        String result = Application.calculate(numText);
        System.out.println(result);
    }

    public static String calculate(String numText) {
        // 1. 입력 문자열의 공백 제거.
        numText = numText.replace(" ", "");

        // 2. split() 메서드를 사용하여 쉼표로 분할한 배열을 생성.
        String[] nums = numText.split(",");
        System.out.println(nums[0]); // 배열 출력하는법 찾아보자

        // 3. 배열 인덱스 0, 1, 2의 요소를 각각 변수에 할당 후 정수형으로 변환.
        int num0 = Integer.parseInt(nums[0]);
        int num1 = Integer.parseInt(nums[1]);
        int num2 = Integer.parseInt(nums[2]);

        // 4. 변수들을 이용해 합계와 평균을 계산.
        int sum = num0 + num1 + num2;
        int avg = sum / 3;

        // 5. 결과 문자열을 생성하여 반환.
        System.out.println("합계: " + sum + ", 평균: " + avg);

        return "합계: " + sum + ", 평균: " + avg;
    }
}
