package com.nightfall.backend.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    @PrePersist
    public void generateUUID() {
        this.id = UUID.randomUUID();
    }
}