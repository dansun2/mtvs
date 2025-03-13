package com.ohgiraffers.c_method.chap01;
/*
 * 1. 메서드의 기본 구조와 동작
 * - 메서드는 특정 작업을 수행하는 코드 블록으로, JVM에서 스택 프레임(Stack Frame)을 통해 관리된다.
 * - 호출 시 스택에 파라미터, 지역 변수, 반환 주소가 저장되고, 종료 시 자동 제거된다.
 * - 예: void printMessage(String msg) -> 호출 시 스택에 msg와 함께 메서드 정보 저장.
 * - 장점: 메모리 관리가 간단하고, 메서드 호출 스택으로 디버깅 용이.
 */

/*
 * 2. 메서드와 성능의 관계
 * - 메서드 호출은 스택 프레임 생성/제거로 약간의 오버헤드가 발생.
 * - JIT(Just-In-Time Compiler)는 자주 호출되는 메서드를 인라인(Inlining)해 최적화.
 * - 너무 "큰 메서드"는 인라인 불가, 너무 작은 메서드는 호출 오버헤드 증가.
 * - 예: 반복문 내에서 작은 메서드를 호출하면 성능 저하 가능성 있음.
 *
 * = 오버헤드 : 작업을 수행하기 위해 추가로 발생하는 시간 및 자원낭비를 의미 (메서드 호출시 스택 생성 및 제거)
 * = 인라인 : 자주 사용되는 함수의 내부 코드를 JIT에서 스택을 생성하지 않고 해당 코드를 직접 삽입
 */

/*
 * 3. 단일 책임 원칙(Single Responsibility Principle, SRP)
 * - 메서드는 하나의 책임(기능)만 가져야 하며, 변경 이유가 하나여야 한다.
 * - 장점:
 *   - 가독성 향상: 코드가 간결하고 이해하기 쉬움.
 *   - 유지보수성 증가: 한 가지 기능만 수정하면 되므로 버그 가능성 감소.
 *   - 성능 최적화 용이: 작은 메서드는 JIT 인라인 가능성이 높아짐.
 * - 예: "문자열 결합"과 "출력"을 하나의 메서드로 합치면 SRP 위반, 분리해야 함.
 * - 실무 적용: SRP를 지키면 코드 재사용성과 테스트 용이성도 개선됨.
 */

/*
 * 4. 성능 최적화 기법
 * - (1) 메서드 크기 조정: 단일 책임 원칙(SRP)에 따라 작고 응집력 있는 메서드로 설계.
 * - (2) 객체 생성 최소화: 반복문 내에서 불필요한 객체 생성(예: String) 피하기.
 * - (3) 메서드 호출 최소화: 반복문 밖으로 상수 계산 이동. (반복문 내에서 함수 호출을 최소화 하자는 의미)
 * - (4) 예외 처리 최적화: 예외를 제어 흐름으로 사용하지 않기. (if로 해결할 수 있는 오류를 Exception을 사용하지 않는다.)
 *      - 기본적으로 예외처리는 성능에 매우 좋지 않은 영향을 주게된다.
 * - 목표: 성능 향상과 유지보수성의 균형 유지.
 */
public class MethodDeep {

    // 실습 코드: 비최적화 vs 최적화 성능 비교
    public static void main(String[] args) {
        // 비최적화: SRP 안 지키고 느린 방법
        long startTime1 = System.currentTimeMillis(); // 시작 시간 (밀리초)
        String result1 = "";
        for (int i = 1; i <= 1000; i++) {
            result1 = mixAddAndPrint(result1, "안녕 " + i); // 두 가지 일 + 느린 문자열 더하기
        }
        long endTime1 = System.currentTimeMillis(); // 끝난 시간



        // 최적화: SRP 지키고 빠른 방법
        long startTime2 = System.currentTimeMillis(); // 시작 시간
        String fastResult = "";
        for (int i = 1; i <= 1000; i++) {
            fastResult = addHello(fastResult, "안녕 " + i); // 한 가지 일만
            printText(fastResult);                           // 출력 따로
        }
        long endTime2 = System.currentTimeMillis(); // 끝난 시간

        System.out.println("성능 비교하기");
        System.out.println("비최적화 시간: " + (endTime1 - startTime1) + " 밀리초");
        System.out.println("최적화 시간: " + (endTime2 - startTime2) + " 밀리초");
    }



    // 비최적화: SRP 안 지킴 (문자열 더하기 + 출력 함께)
    public static String mixAddAndPrint(String base, String text) {
        String combined = base + text; // 느린 문자열 더하기
        System.out.println(combined);  // 출력까지 함
        return combined;
    }

    // 최적화: SRP 지킴 (문자열 더하기만)
    public static String addHello(String base, String text) {
        return base + text; // 한 가지 일: 문자열 더하기
    }

    // 최적화: SRP 지킴 (출력만)
    public static void printText(String text) {
        System.out.println(text); // 한 가지 일: 출력
    }

}