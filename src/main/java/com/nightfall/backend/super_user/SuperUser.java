package com.nightfall.backend.super_user;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nightfall.backend.role.Role;
import lombok.Data;
import java.util.*;

@Entity
@Table(name = "super_user")
@Data
public class SuperUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
