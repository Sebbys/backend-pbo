package com.nightfall.backend.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id", updatable = false, nullable = false)
    private UUID productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stock;

    @PrePersist
    public void generateUUID() {
        if (this.productId == null) {
            this.productId = UUID.randomUUID();
        }
    }
}
