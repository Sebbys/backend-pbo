package com.nightfall.backend.dto;
import lombok.*;
import java.util.*;
import com.nightfall.backend.dto.*;

@Data
public class TransactionItemDTO {
    private UUID productId;
    private int quantity;
}