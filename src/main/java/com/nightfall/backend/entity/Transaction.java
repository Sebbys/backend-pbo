package com.nightfall.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TransactionItem> items = new ArrayList<>();

    private double totalAmount;

    private LocalDateTime timestamp = LocalDateTime.now();
}