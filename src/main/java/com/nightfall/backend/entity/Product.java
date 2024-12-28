package com.nightfall.backend.entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private double price;
    private int quantity; // Add quantity field
}