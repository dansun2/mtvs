package com.ohgiraffers.inheritance.chap01.section03.model;

import com.ohgiraffers.inheritance.chap01.section02.model.Product;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*
* 자식 클래스
* @DiscriminatorValue("CLOTHING")
*조인 전략에서 @DiscriminatorValue("CLOTHING")은 해당 하위 클래스의 엔티티가 저장될 때
* PRODUCT_TYPE 컬럼에 저장될 특정 값을 정의하며,
* JPA는 이 값을 기반으로 어떤 하위 클래스의 데이터를 조인하여 로드할지 결정한다.
* */
@Entity
@Table(name = "clothing_products_joined")
@DiscriminatorValue("CLOTHING")
public class ClothingProductJoined extends ProductJoined {

    private String size;
    private String color;
    private String material;

    protected ClothingProductJoined() {
    }

    public ClothingProductJoined(String name, String brand, int stockQuantity, String size, String color, String material) {
        super(name, brand, stockQuantity);
        this.size = size;
        this.color = color;
        this.material = material;
    }

    @Override
    public String toString() {
        return "ClothingProductJoined{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
