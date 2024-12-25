package com.nightfall.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

import com.nightfall.backend.entity.SuperUser;


public interface UserRepository extends JpaRepository<SuperUser, UUID> {
}