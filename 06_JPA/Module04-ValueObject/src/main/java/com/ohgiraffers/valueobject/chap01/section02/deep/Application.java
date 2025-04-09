package com.ohgiraffers.valueobject.chap01.section02.deep;

import com.ohgiraffers.valueobject.chap01.section02.model.vo.GuestCount;
import com.ohgiraffers.valueobject.chap01.section02.model.vo.StayPeriod;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/*
 * DeepDive 값 타입(Value Object)의 메모리 구조와 동작 이해
 * */
public class Application {
    public static void main(String[] args) {
        /*
         * equals & hashCode 재정의의 중요성 (동등성 비교)
         * - 값 객체는 값이 같으면 논리적으로 같은 객체로 간주되어야 한다.
         * - equals()를 재정의하지 않으면 객체의 참조 주소를 비교하게 되어 값이 같더라도 다르다고 판단한다.
         * */
        GuestCount guestCount = new GuestCount(1);
        GuestCount guestCount2 = new GuestCount(1);
        System.out.println("주소 값으로 확인하기 : " + (guestCount == guestCount2));
        System.out.println("값을 기준으로 확인하기 : " + (guestCount.equals(guestCount2)));

        /*
         * hashCode 재정의 필요성
         * - hashCode를 올바르게 재정의하지 않으면 hashSet과 같은 컬렉션에서 같은 값을 가진 객체를 중복으로 저장할 수 있다.
         * */
        Set<GuestCount> guestCounts = new HashSet<>();
        guestCounts.add(guestCount);
        guestCounts.add(guestCount2);
        System.out.println("hashSet 크기 : " + guestCounts.hashCode());


        /*
         * 불변성 설계의 이점
         * - GuestCount와 StayPeriod는 생성 시점 이후 내부 상태를 변경할 수 있는 setter를 제공하지 않는다.
         * - 이는 다음과 같은 이점을 제공하게 된다.
         * 1. 안전성 향상 : 객체가 생성된 후에는 값이 변하지 않으므로 예기치 않는 side Effect 발생 가능성을 줄인다.
         * 2. 예측 가능성 : 객체의 상태가 항상 일정하므로 코드를 이해하고 예측하기 쉬워진다.
         * 3. 멀티스레드 환경 안정 : 여러 스레드에서 동시에 접근해도 데이터 불변성으로 인해 안전하다.
         * 4. equals/hashCode 기반 비교의 안정성 확보 : 객체의 상태가 변하지 않으므로 equals()와 hashCode()의 결과가 일관성을 유지한다.
         * */
        StayPeriod period = new StayPeriod(
                LocalDate.of(2025,8,9),
                LocalDate.of(2025, 9,10)
        );
        System.out.println("최종 숙박일 수 : " + period.getNights());

        // setter 메서드가 없기 때문에 값 변경이 불가능함.
        //period.set

        // 값을 변경해야 하는 경우는 값을 새롭게 만들어야 한다.
        StayPeriod period1 = new StayPeriod(
                LocalDate.of(2025,8,9),
                LocalDate.of(2025, 9,11)
        );
        System.out.println(period.equals(period1));
    }
}
