package com.nightfall.backend.dto;
import lombok.*;
import java.util.*;
import com.nightfall.backend.dto.*;

@Data
public class TransactionItemDTO {

    private UUID transactionItemId;
    private int quantity;
    private double price;
    private ProductDTO product;

    // Getters and Setters
}
