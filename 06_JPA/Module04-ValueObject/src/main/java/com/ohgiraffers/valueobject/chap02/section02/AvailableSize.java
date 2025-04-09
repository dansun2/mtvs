package com.ohgiraffers.valueobject.chap02.section02;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class AvailableSize {
    private String label;
    private int stockQuantity;

    protected AvailableSize() {

    }

    public AvailableSize(String label, int stockQuantity) {
        if(label == null || label.trim().isEmpty()) {
            throw new IllegalArgumentException("사이즈 라벨은 필수 입니다.");
        }

        if(stockQuantity < 0) {
            throw new IllegalArgumentException("재고 수량은 0이상이어야 합니다.");
        }
        this.label = label;
        this.stockQuantity = stockQuantity;
    }

    public void decreaseStock(int quantity){
        if(this.stockQuantity - quantity < 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.stockQuantity -= quantity;
    }

    public String getLabel() {
        return label;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }


    @Override
    public boolean equals(Object o) {
        if(this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        AvailableSize that = (AvailableSize) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }


    @Override
    public String toString() {
        return  label + "재고 : "+ stockQuantity;
    }
}
