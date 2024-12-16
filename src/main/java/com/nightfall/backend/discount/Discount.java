package com.nightfall.backend.discount;

import com.nightfall.backend.product.Product;
import com.nightfall.backend.transaction.Transaction;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "discount")
public class Discount {
    @Id
    private String discountId;
    private String discountType;
    private Double value;

    @OneToMany(mappedBy = "discount", cascade = CascadeType.PERSIST)
    private Set<Product> products;

    @OneToMany(mappedBy = "discount", cascade = CascadeType.PERSIST)
    private Set<Transaction> transactions;

    // Getters and setters
    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
