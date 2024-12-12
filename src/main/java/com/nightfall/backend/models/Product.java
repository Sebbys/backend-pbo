package com.nightfall.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private double price;

    @ManyToOne
    private Discount discount;

    public double getEffectivePrice() {
        return price;
    }

    public String getProductName(){
        return name;
    }
}