package com.nightfall.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Discount {
    @Id
    private String discountId;
    // private String discountType;
    private double value;

    public double applyDiscount(double price) {
        return price - (price * value / 100);
    }
}

