package com.ohgiraffers.b_variable.chap02;

public class DataTypeDeep {
    public static void main(String[] args) {
        /*
         * [데이터 타입의 딥한 개념: 부동소수점과 정밀도]
         * 자바의 실수형(`float`, `double`)은 IEEE 754 부동소수점 표준을 따릅니다.
         *
         * - 부동소수점(Floating-Point): 실수를 부호(Sign), 지수(Exponent), 가수(Mantissa)로 표현.
         *   - `float`: 32비트 (부호 1비트, 지수 8비트, 가수 23비트)
         *   - `double`: 64비트 (부호 1비트, 지수 11비트, 가수 52비트)
         * - 구조
         *  - 부호 비트 (Sign Bit) : 숫자가 양수인지 음수인지 낸다.
         *  - 지수 (Exponent): 숫자의 크기(스케일)를 결정하며, 2의 거듭제곱으로 표현
         *  - 가수 (Mantissa, 또는 Significand): 숫자의 유효숫자(소수점 이하 포함)를 나타낸다.
         *
         * - 이진 표현의 한계:
         *   - 10진수 소수(예: 0.1)는 이진수로 정확히 표현되지 않음(무한 소수).
         *   - 예: 0.1(10진수) = 0.000110011... (2진수, 반복).
         *   - 이로 인해 근사값으로 저장되며, `float`보다 `double`이 더 높은 정밀도를 제공.
         * - 부동소수점 오차:
         *   - 연산(덧셈, 비교 등) 시 미세한 오차가 누적될 수 있음.
         *   - 예: 0.1 + 0.2는 정확히 0.3이 되지 않고, 약 0.30000000000000004로 계산.
         * - 실무적 함의:
         *   - 실수 비교 시 `==` 대신 오차 범위(예: Math.abs(a - b) < 0.0001)를 사용 권장.
         *   - 정밀도가 중요한 경우 `BigDecimal` 클래스를 고려.
         */

        // float vs double 비교
        float fVal = 0.1f;
        double dVal = 0.1;

        // 같은 0.1이지만 내부 이진 표현이 달라, 미세한 오차 가능
        System.out.println("float: " + fVal);
        System.out.println("double: " + dVal);
        System.out.println("float == double ? " + (fVal == dVal));

        /*
         * [부동소수점 오차 예시]
         */
        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = 0.3;

        System.out.println(d1 + d2 == d3); // 의도치 않게 false일 수 있음
        // 이유: 0.1 + 0.2 = 0.30000000000000004와 같은 근사값이 됨.

        //이는 이진 부동소수점 표현 방식의 한계로 발생하는 문제
    }
}
