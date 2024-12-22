package com.nightfall.backend.transaction;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @EntityGraph(attributePaths = {"customer", "discount", "transactionItems"})
    @Query("SELECT t FROM Transaction t")
    List<Transaction> findAllWithCustomerDiscountAndItems();
}