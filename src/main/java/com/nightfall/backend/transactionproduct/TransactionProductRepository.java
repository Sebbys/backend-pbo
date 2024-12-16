package com.nightfall.backend.transactionproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionProductRepository extends JpaRepository<TransactionProduct, String> {
}
