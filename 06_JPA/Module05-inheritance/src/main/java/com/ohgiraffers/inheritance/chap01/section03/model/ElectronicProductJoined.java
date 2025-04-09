package com.ohgiraffers.inheritance.chap01.section03.model;

import com.ohgiraffers.inheritance.chap01.section02.model.Product;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "eletronic_product_joined")
@DiscriminatorValue("ELECTRONIC")
public class ElectronicProductJoined extends ProductJoined {

    private int warrantyPeriod;
    private String powerConsumption;

    protected ElectronicProductJoined() {
    }

    public ElectronicProductJoined(String name, String brand, int stockQuantity, int warrantyPeriod, String powerConsumption) {
        super(name, brand, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
        this.powerConsumption = powerConsumption;
    }

    @Override
    public String toString() {
        return "ElectronicProductJoined{" +
                "warrantyPeriod=" + warrantyPeriod +
                ", powerConsumption='" + powerConsumption + '\'' +
                '}';
    }
}
