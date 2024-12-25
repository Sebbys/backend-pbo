package com.nightfall.backend.dto;
import lombok.*;
import java.util.*;
import com.nightfall.backend.dto.*;

@Data
public class ProductDTO {

    private UUID productId;
    private String name;
    private String description;
    private double price;
    private int stock;

    // Getters and Setters
}
