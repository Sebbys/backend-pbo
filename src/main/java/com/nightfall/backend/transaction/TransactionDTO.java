package com.nightfall.backend.transaction;

import com.nightfall.backend.customer.Customer;
import com.nightfall.backend.discount.Discount;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
public class TransactionDTO {
    private UUID transactionId;
    private Customer customer;
    private Timestamp date;
    private BigDecimal total;
    private Discount discount;
    private List<TransactionItemDTO> items;

    @Getter
    @Setter
    public static class TransactionItemDTO {
        private UUID transactionItemId;
        private String productName;
        private BigDecimal productPrice;
        private int quantity;
    }

    public TransactionDTO(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.customer = transaction.getCustomer();
        this.date = transaction.getDate();
        this.total = transaction.getTotal();
        this.discount = transaction.getDiscount();
        this.items = transaction.getTransactionItems().stream()
                .map(item -> {
                    TransactionItemDTO dto = new TransactionItemDTO();
                    dto.setTransactionItemId(item.getTransactionItemId());
                    dto.setProductName(item.getProduct().getName());
                    dto.setProductPrice(item.getProduct().getPrice());
                    dto.setQuantity(item.getQuantity());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}