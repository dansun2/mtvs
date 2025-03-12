package com.ohgiraffers.f_activity.mission;

public class Application {
    public static void main(String[] args) {
        String text = "Java is Fun";
        String result = Application.calculate(text);
        System.out.println(result);
    }

    public static String calculate(String text) {
        // 1. 문자열의 공백을 기준으로 분할해서 배열에 넣어줌
        String[] texts = text.split(" ");

        // 2. 길이의 합계를 저장할 정수타입 변수를 만들고 (textLength0,1,2) 각 단어의 길이를 length로 계산해서 변수에 넣어줌
        int textLength0 = texts[0].length();
        int textLength1 = texts[1].length();
        int textLength2 = texts[2].length();

        // 3. sum 으로 길이의 합계 계산
        int sum = textLength0 + textLength1 + textLength2;
        return "단어1: " + textLength0 + ", 단어2: " + textLength1 + ", 단어3: " + textLength2 + ", 총 길이: " + sum;
    }
}
