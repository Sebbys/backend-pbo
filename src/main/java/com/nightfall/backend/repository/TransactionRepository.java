package com.nightfall.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

import com.nightfall.backend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}