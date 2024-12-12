package com.nightfall.backend.models;

// import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Transaction {
    @Id
    private String transactionId;
    // private Date date;
    private double total;

    @OneToMany
    private List<Product> items = new ArrayList<>();

    public void calculateTotal() {
        if (items != null) {
            total = items.stream()
                         .mapToDouble(Product::getEffectivePrice)
                         .sum();
            System.out.println("Total: " + total);
        } else {
            total = 0;
            System.out.println("Total: " + total);
        }
    }
}
