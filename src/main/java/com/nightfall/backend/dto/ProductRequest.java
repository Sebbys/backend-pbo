package com.nightfall.backend.dto;
import lombok.*;

@Data   
public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private int stock;

    // Getters and setters (or use Lombok's @Data for brevity)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
