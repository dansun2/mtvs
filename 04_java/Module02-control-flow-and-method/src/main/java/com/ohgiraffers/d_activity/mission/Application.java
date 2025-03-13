package com.ohgiraffers.d_activity.mission;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();

        // 입력 형태가 배열이기 때문에 배열을 만들어서 입력값 전달
        int numbers[] = {1, 3, 5, 8};

        // processNumber 메서드에 매개변수로 전달해서 실행
        application.processNumber(numbers);
    }

    public String processNumber(int[] input) {

        // 1. 입력 숫자가 있는지 확인
        if (input == null || input.length == 0) {
            return "숫자를 입력해주세요.";
        }

        // 2. for문을 사용하여 배열의 각 요소를 순회한다.
        int ren = input.length;

        // 결과를 넣어줄 변수
        String result = "";

        // 배열의 길이가 4기 때문에 배열의 길이만큼 반복
        for (int i = 0; i < ren; i++) {
            int number = input[i]; // 배열의 0~3번째 인덱스의 값

            // 숫자에 맞는 요일을 result에 넣음
            switch (number) {
                case 1 -> result += "Monday";
                case 2 -> result += "Tuesday";
                case 3 -> result += "Wednesday";
                case 4 -> result += "Thursday";
                case 5 -> result += "Friday";
                case 6 -> result += "Saturday";
                case 7 -> result += "Sunday";
                default -> result += "Unknown";
            }

            // 배열의 길이가 끝나기 전까지 ", "를 넣어줌
            if (i != ren - 1) {
                result += ", ";
            }
        }
        return result;
    }
}
