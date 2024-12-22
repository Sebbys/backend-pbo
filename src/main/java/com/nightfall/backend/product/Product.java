package com.nightfall.backend.product;

import jakarta.persistence.*;
import com.nightfall.backend.discount.Discount;
import com.nightfall.backend.transaction.Transaction;
import java.util.Set;
import java.util.List;
import java.math.BigDecimal;

import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int stockQuantity;

    // Getters and setters
    public UUID getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stockQuantity;
    }

    public void setStock(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}