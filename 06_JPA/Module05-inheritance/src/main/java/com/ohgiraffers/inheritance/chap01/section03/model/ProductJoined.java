package com.ohgiraffers.inheritance.chap01.section03.model;


import jakarta.persistence.*;


/*
* 부모 클래스 ProductJoined
* @Inheritance(strategy= InheritanceType.JOINED)
* - 이 애노테이션은 엔티티 상속 전략을 정의한다.
* - InheritanceType.Joined 전략은 상속 계층의 각 클래스를 별도의 테이블에 매핑한다.
* - 부모 클래스인 ProductJoinde의 속성들은 "Products_joined" 테이블에 저장되고
* - 자식 클래스의 고유한 속성들은 각각의 테이블에 저장된다.
* - 자식 클래스의 레코드를 조회할 때는 부모 테이블과 자식 테이블을 조인(Join)하여 데이터를 가져온다.
*
* @DicriminatorColumn(name="product_type")
* - 이 애노테이션은 Joined 상속 전략에서도 사용되며, 레코드의 타입을 구분하는 컬럼을 지정한다.
* - Product_joined 테이블에 Product_type이라는 컬럼이 생성되며, 각 레코드가 어떤 하위 클래스의 인스턴스인지 나타내는 값을 저장한다.
* - 이 컬럼의 값에 따라 JPA는 어떤 자식 테이블과 조인해야 할지 결정한다.
* - 예를 들어 ClotinhgProductJoined 클래스가 ProductJoind를 상속받고,
*   @DiscriminatorValue("Clothing)어노테이션을 가지고 있다면
* - product_type 컬럼에 "Clothing)과 같은 값이 저장된다.
* */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="product_type")
@Table(name = "products_joined")
public class ProductJoined {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private int stockQuantity;

    public ProductJoined() {
    }

    public ProductJoined(String name, String brand, int stockQuantity) {
        this.name = name;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "ProductJoined{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
