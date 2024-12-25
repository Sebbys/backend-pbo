package com.nightfall.backend.dto;
import lombok.*;
import java.util.*;

import lombok.Data;
import java.util.List;

@Data
public class TransactionDTO {
    private List<TransactionItemDTO> items;
    private String discountCode; // New field for discount code
}
