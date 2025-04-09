package com.ohgiraffers.valueobject.chap01.section02.model.vo;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/*
 * 값 객체
 * - 단순히 체크인 날짜와 체크아웃 날짜를 Reservation 엔티티의 필드로 관리할 수 있지만,
 *   StayPeriod라는 값 객체를 도입함으로써 이 두 날짜가 하나의 의미 있는 "기간"이라는 개념을 명확하게 표현할 수 있다.
 * - StayPeriod 내부에 해당 기간과 관련된 비즈니스 로직(예 : 체크아웃 날짜가 체크인 날짜 이후여야 한다는 규칙)을 캡슐화하여
 *   데이터의 유효성을 확보하고 코드의 응집도를 높일 수 있다.
 * - JPA에서는 @Embeddable 어노테이션을 사용해서 Stayperiod 클래스를 값 타입으로 정의하고,
 *   Reservation 엔티티 내에 @Embedded 어노테이션으로 포함시켜 마치 Reservation 엔티티의 속성처럼 취급할 수 있도록 한다.
 * */
@Embeddable // ID 어노테이션 쓸 수 없음
public class StayPeriod {
    private LocalDate startDate;
    private LocalDate endDate;

    protected StayPeriod() {}

    public StayPeriod(LocalDate startDate, LocalDate endDate) {
        if(endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("체크인 날짜는 체크아웃 이전이어야 합니다.");
        }
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // period.between(startDate, endDate) 이 메서드는 두 날짜 사이의 기간을 계산하여 Period 객체를 반환하며
    // getDays()를 이용하여 일수만 추출할 수 있다.
    public int getNights(){
        return Period.between(startDate, endDate).getDays();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        StayPeriod that = (StayPeriod) o;
        return Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}
