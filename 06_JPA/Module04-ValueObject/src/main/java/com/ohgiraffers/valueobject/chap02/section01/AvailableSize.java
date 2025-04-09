package com.ohgiraffers.valueobject.chap02.section01;

import jakarta.persistence.*;

@Entity(name = "section01_available")
@Table(name = "product_available_sizes_section01")
public class AvailableSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "label")
    private String label;

    @Column(name = "stockQuantity")
    private int stockQuantity;

    protected AvailableSize() {
    }

    public AvailableSize( String label, int stockQuantity) throws IllegalAccessException {
        if(label == null || label.trim().isEmpty()) {
            throw new IllegalAccessException("사이즈 라벨은 필수 입니다.");
        }
        if(stockQuantity < 0) {
            throw new IllegalAccessException("재고 수량은 0 이상이여야 합니다.");
        }
        this.label = label;
        this.stockQuantity = stockQuantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    /*
     * 해당 사이즈의 재고 수량을 주어진 quantity 만큼 감소시킨다.
     * 재고가 부족하면 IllegalAccessException을 발생
     * */
    public void decreaseStockQuantity(int stockQuantity) throws IllegalAccessException {
        if(this.stockQuantity-stockQuantity < 0) {
            throw new IllegalAccessException("재고가 부족합니다.");
        }
        this.stockQuantity -= stockQuantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public String getLabel() {
        return label;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public String toString() {
        return label+ "재고 : " +
                stockQuantity;
    }
}
