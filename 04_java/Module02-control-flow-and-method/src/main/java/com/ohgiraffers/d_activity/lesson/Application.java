package com.ohgiraffers.d_activity.lesson;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        String result = application.processNumbers("10, 20, 30, 40");
        System.out.println(result);
    }

    /**
     * 쉼표로 구분된 숫자 문자열을 받아 합계, 평균, 짝수 갯수, 홀수 갯수를 계산하여
     * 결과를 문자열로 반환하는 함수
     *
     * @param input 쉼표로 구분된 숫자 문자열(10, 20, 30, 40)
     * @return "합계: <sum>, 평균: <avg>, 짝수 개수: <evenCount>, 홀수 개수: <oddCount>" 형태의 결과 문자열 반환
    * */
    public String processNumbers(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "입력 없음";
        }
        // 1. 입력 문자열에서 모든 공백을 제거
        String cleanedInput = input.replace(" ","");

        // 2. 쉼표(,)를 기준으로 문자열 배열을 생성한다.
        String[] parts = cleanedInput.split(",");

        // 3. for문을 사용하여 각 배열 요소를 순차적으로 정수로 변환한다.
        int sum = 0;
        int evenCount = 0;
        int oddCount = 0;
        int count = parts.length;

        for (String part : parts) {
            int number = Integer.parseInt(part);
            // 배열을 순차적으로 확인하면서 합계를 구함
            sum += number;

            // 짝수일 때 카운트
            if (number % 2 == 0) {
                evenCount++;
            } else { // 홀수일 때 카운트
                oddCount++;
            }
        }
        // 평균 구하기
        int avg = sum / count;

        return "합계: " + sum + ", 평균: " + avg + ", 짝수 개수: " + evenCount + ", 홀수 개수: " + oddCount;
    }
}
