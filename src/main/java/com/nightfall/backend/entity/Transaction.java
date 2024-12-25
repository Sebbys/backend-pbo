package com.nightfall.backend.entity;


import lombok.Data;
import jakarta.persistence.*;
import java.util.*; 

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transactionId;
    
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionItem> items; // This field represents the transaction items
    
    private double totalPrice;
    private Date transactionDate;
}

