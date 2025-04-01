package com.ohgiraffers.chap01.section03;

import jakarta.persistence.*;

/*
* Embedded 타입
* 값 객체(Value Object)의 대표 사례인 "가격(money)"를 통해 알아본다.
*
* 복합 값 타입의 사용 목적
* - 공통 필드를 하나의 객체로 묶어서 코드 재사용성을 높임
* - 엔티티와 값 타입의 역할 분리 -> 객체지향 설계에 적합
* - JPA가 내부적으로 해당 필드들을 컬럼으로 펼쳐서 저장
*
* */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /*
    * @Embedded 사용
    * - 가격 정보는 단순 숫자로 처리할 수도 있지만 실무에서는 통화, 할인 여부 등을 포함하는 구조가 일반적이다.
    * */
    @Embedded
    private Money price;

    @Embedded
    @AttributeOverrides({ // 컬럼의 충돌의 피하기 위해 쓰는거임
        @AttributeOverride(name = "name", column = @Column(name = "manufacturer_name")),
        @AttributeOverride(name = "country", column = @Column(name = "manufacturer_country"))
    })
    private Manufacturer manufacturer;

    protected Product() {
    }

    public Product(Long id, String name, Money price, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public void changePrice(Money newPrice) {
        this.price = newPrice;
    }

    public void changeManufacturer(Manufacturer newManufacturer) {
        this.manufacturer = newManufacturer;
    }

    public Long getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
