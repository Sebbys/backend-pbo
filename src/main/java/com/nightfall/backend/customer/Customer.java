package com.nightfall.backend.customer;

import com.nightfall.backend.role.Role;
import com.nightfall.backend.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;


@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID customerId;

    private String name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Role role;

    // Getters and setters
    public UUID getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}
