package com.nightfall.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class SuperUser extends Role {
    private String username;
    private String password;
    // Add any other fields specific to super users
}