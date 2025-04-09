package com.ohgiraffers.inheritance.chap01.section02.model;


import jakarta.persistence.*;

/*
* Inheritance
* - 해당 어노테이션은 엔티티 상속 전략을 정의한다.
* - single_table 전략은 상속 계층의 모든 클래스를 하나의 테이블에 매핑하다.
* - 즉, Product 클래스와 그 하위 클래스들의 모든 속성이 Products 테이블이라는 하나의 테이블에 저장된다.
*
* DiscriminatoerColumn
* - 이 애노테이션은 Single_table 상속 전략에서 사용되며, 레코드의 타입을 구분하는 칼럼을 지정한다.
* - product_type이라는 컬럼이 Products 테이블에 생성되며 각 레코드가 어떤 하위 클래스의 인스턴스인지 나타내는 값을 저장한다.
* - 예를 들어 Book 클래스가 Product를 상속받는 다면 product_type 컬럼에 book과 같은 값이 저장될 수 있다.
* */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type")
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String brand;
    private int stockQuantity;

    public Product() {
    }

    public Product(String name, double price, String brand, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
