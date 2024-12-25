package com.nightfall.backend.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;
import com.nightfall.backend.entity.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
public class TransactionItem {
    @Id
    @GeneratedValue
    private UUID id; // Unique identifier for TransactionItem

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonBackReference
    private Transaction transaction; // Back-reference to Transaction
}