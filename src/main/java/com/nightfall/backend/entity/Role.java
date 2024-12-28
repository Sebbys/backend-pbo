package com.nightfall.backend.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    private String roleName;
}