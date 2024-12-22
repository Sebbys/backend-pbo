package com.nightfall.backend.discount;

import com.nightfall.backend.product.Product;
import com.nightfall.backend.transaction.Transaction;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.*;
import lombok.Data;

@Entity
@Data
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID discountId;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal percentage;

    private LocalDate validFrom;
    private LocalDate validTo;

    @Column(name = "is_active")
    private boolean active = true;

    @Column(name = "max_usage_limit")
    private Integer maxUsageLimit;

    @Column(name = "current_usage_count")
    private Integer currentUsageCount = 0;

    public boolean isValid() {
        LocalDate now = LocalDate.now();
        return active && 
               (validFrom == null || !now.isBefore(validFrom)) &&
               (validTo == null || !now.isAfter(validTo)) &&
               (maxUsageLimit == null || 
                currentUsageCount < maxUsageLimit);
    }


}
