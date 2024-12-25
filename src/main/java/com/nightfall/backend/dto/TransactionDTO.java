package com.nightfall.backend.dto;
import lombok.*;
import java.util.*;


@Data
public class TransactionDTO {

    private UUID transactionId;
    private double totalPrice;
    private Date transactionDate;
    private List<TransactionItemDTO> items;

    // Getters and Setters
}
