package com.ohgiraffers.valueobject.chap02.section02;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "section02_product_entity")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;


    private String name;

    /*
     * @ElementCollection
     * - Product 엔티티가 AvailableSize 타입의 값 객체 컬렉션을 가짐을 명시
     *  - 하나의 상품이 여러 개의 가능한 사이즈를 가질 수 있다.
     *
     * @CollectionTable
     * - 'availableSizes" 컬렉션을 저장할 별도의 테이블 "product_available_sizes"로 지정한다.
     * - product_id 컬럼을 외래 키로 사용하여 Product 엔티티의 id와 연결한다.
     * */
    @ElementCollection
    @CollectionTable(name = "product_available_sizes",joinColumns = @JoinColumn(name = "product_id"))
    private List<AvailableSize> availableSizes = new ArrayList<>();


    protected Product() {

    }

    public Product(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public List<AvailableSize> getAvailableSizes() {
        return availableSizes;
    }

    public void addVailableSize(AvailableSize availableSize) {
        this.availableSizes.add(availableSize);
    }

    /*
     * - equals를 활용하여 제거
     * */
    public void removeAvailableSize(AvailableSize availableSize) {
        this.availableSizes.removeIf(size -> size.equals(availableSize));
    }

    public void decreaseStock(String sizeLabel, int quantity) {
        for (AvailableSize availableSize : availableSizes) {
            if(availableSize.getLabel().equals(sizeLabel)) {
                availableSize.decreaseStock(quantity);
                return;
            }
        }
        throw new IllegalArgumentException("해당 사이즈 상품이 없습니다. " + availableSizes);
    }
}
