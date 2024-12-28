package com.nightfall.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;
import com.nightfall.backend.entity.SuperUser;

public interface SuperUserRepository extends JpaRepository<SuperUser, UUID> {
    Optional<SuperUser> findByUsername(String username);
}
