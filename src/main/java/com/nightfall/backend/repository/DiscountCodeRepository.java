package com.nightfall.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;
import com.nightfall.backend.entity.DiscountCode;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, UUID> {
    Optional<DiscountCode> findByCode(String code);
}
