package com.ohgiraffers.valueobject.chap02.section01;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "section01_product")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    private String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvailableSize> availableSizes = new ArrayList<>();

    protected Product() {}

    public Product(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AvailableSize> getAvailableSizes() {
        return availableSizes;
    }

    public void addAvailableSize(AvailableSize availableSize) {
        this.availableSizes.add(availableSize);
        availableSize.setProduct(this);
    }

    public void removeAvailableSize(AvailableSize availableSize) {
        this.availableSizes.remove(availableSize);
        availableSize.setProduct(null);
    }

    public void decreaseStock(String sizeLabel, int quantity) throws IllegalAccessException {
        for (AvailableSize availableSize : availableSizes) {
            if(availableSize.getLabel().equals(sizeLabel)){
                availableSize.decreaseStockQuantity(quantity);
                return;
            }
        }
        throw new IllegalAccessException("해당 사이즈의 상품이 없습니다."+ sizeLabel);
    }
}
