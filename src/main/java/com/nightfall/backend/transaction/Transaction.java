package com.nightfall.backend.transaction;

import jakarta.persistence.*;
import com.nightfall.backend.customer.Customer;
import com.nightfall.backend.discount.Discount;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private Timestamp date;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    // Getters and setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

}
