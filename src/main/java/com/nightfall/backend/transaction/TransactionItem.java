package com.nightfall.backend.transaction;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "transaction_item")
public class TransactionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transaction_item_id")
    private UUID transactionItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    @Column(name = "product_id", nullable = false)
    private UUID productId;  // Change from String to UUID

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}
