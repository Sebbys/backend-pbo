package com.nightfall.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;

    public void authenticate() {
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Authenticated");
        } else {
            System.out.println("Authentication failed");
        }
    }
}