package com.nightfall.backend.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;

@Data
@Entity
public class DiscountCode {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String code;
    private double discountPercentage; // For example, 10 for 10% discount
    private boolean active;
}