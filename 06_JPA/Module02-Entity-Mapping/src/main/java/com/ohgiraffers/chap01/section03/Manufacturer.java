package com.ohgiraffers.chap01.section03;

import jakarta.persistence.Embeddable;

import java.util.Objects;

/*
* Value Object란?
* VO는 값 자체가 객체로서 의미를 가지는 설계 개념이다.
* 식별자가 없고 그 값 자체가 객체의 정체성을 정의한다.
* 값이 같으면 같은 객체로 간주하며, 변경이 불가능한 구조로 설계된다.
* 
* 예시)
* - 주소, 기간, 이름, 좌표 등
* - 서울특별시 종로구라는 주소는 같은 값을 가진다면 동일한 의미로 판단한다.
* 
* VO 설계 시 특징
* -> VO 자체만으로 뭘 하진 않는다.
* 1. 불변성 보장 : 필드를 final로 설정하고 setter 제거
* 2. 동등성 비교 : equals()와 hashCode() 재정의
* 3. 상태 변경이 아닌 대체 방식 사용 : 값이 바뀌면 새 객체를 생성
* 4. 도메인 내의 의미 있는 단위로 캡슐화
* */
@Embeddable
public class Manufacturer {
    private String name;
    private String country;

    public Manufacturer() {
    }

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(name, that.name) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
