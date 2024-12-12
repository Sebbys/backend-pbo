package com.nightfall.backend.models;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    private String name;
    private String contact;

    public String getContactInfo() {
        return "Name: " + name + ", Contact: " + contact;
    }
}