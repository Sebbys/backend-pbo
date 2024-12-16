package com.nightfall.backend.product;

import jakarta.persistence.*;
import com.nightfall.backend.discount.Discount;
import com.nightfall.backend.transaction.Transaction;
import com.nightfall.backend.transaction.TransactionProduct;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionProduct> transactionProducts;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public List<TransactionProduct> getTransactionProducts() {
        return transactionProducts;
    }

    public void setTransactionProducts(List<TransactionProduct> transactionProducts) {
        this.transactionProducts = transactionProducts;
    }
}