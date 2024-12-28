package com.nightfall.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.util.UUID;


@Entity
@EqualsAndHashCode(callSuper=false)
@Data
public class SuperUser extends Role {
    private String username;
    private String password;
}