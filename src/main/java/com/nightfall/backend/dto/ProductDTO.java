package com.nightfall.backend.dto;
import lombok.*;
import java.util.*;
import com.nightfall.backend.dto.*;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;

    // Getters and Setters
}