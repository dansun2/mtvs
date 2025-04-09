package com.ohgiraffers.inheritance.chap01.section04.model;

import jakarta.persistence.*;
/*
* 부모 클래스 ProductTPC
* -Inheritancetype.Table_per_class 전략은 상속 계층의 각 클래스마다 별도의 테이블을 생성한다.
* - 부모 클래스인 ProductTPC의 속성들은 ProductTPC에 해당하는 테이블에 저장되고,
* - 각 자식 클래스의 속성들은 각각의 테이블에 저장된다.
* - 이때 각 자식 테이블은 부모의 클래스의 모든 속성을 포함하여 독립적인 구조를 가진다.
* - 즉, 상속된 속성들이 각 자식 클래스의 테이블에 중복되어 저장한다.
* - 부모 클래스 타입으로 조회할 경우 모든 자식 테이블을 union All 연산을 통해 통합하여 결과를 얻는다.
* - 이 전략은 데이터의 물리적인 분리를 명확하게 하고 , 특정 하위 클래스의 데이터를 조회할 때 효율적일 수 있으나,
*   전체 상속 구조에 대한 조회가 필요할 경우 성능상 이슈가 발생할 수 있으며, 데이터 중복으로 인해 관리상 어려움이 있을 수 있다.
* */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProductTPC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private double price;
    private String brand;
    private int stockQuantity;

    public ProductTPC() {
    }

    public ProductTPC(String name, double price, String brand, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "ProductTPC{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
