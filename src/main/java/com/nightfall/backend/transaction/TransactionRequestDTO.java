package com.nightfall.backend.transaction;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TransactionRequestDTO {
    private UUID customerId;
    private Timestamp date;
    private BigDecimal total;
    private UUID discountId;
    private List<TransactionItemDTO> transactionItems;

    @Getter
    @Setter
    public static class TransactionItemDTO {
        private UUID productId;
        private BigDecimal price;
        private int quantity;
    }
}
