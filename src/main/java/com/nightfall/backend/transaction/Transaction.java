package com.nightfall.backend.transaction;

import jakarta.persistence.*;
import com.nightfall.backend.customer.Customer;
import com.nightfall.backend.discount.Discount;
import java.sql.Timestamp;
import java.util.Set;
import java.util.*;
import java.math.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", columnDefinition = "UUID")
    private UUID transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private Timestamp date;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY)
    private Set<TransactionItem> transactionItems = new HashSet<>();
}