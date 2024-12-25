package com.nightfall.backend.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.UUID;

@Data
@Entity
public class TransactionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transactionItemId;

    private int quantity;
    private double price; // Can also be copied from the Product price if needed

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // Foreign key to the Product entity
    private Product product;

    @ManyToOne
    @JoinColumn(name = "transaction_id") // Foreign key to the Transaction entity
    private Transaction transaction;
}
