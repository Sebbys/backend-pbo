package com.nightfall.backend.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    
    List<Transaction> findByCustomer_CustomerId(String customerId);
    
    List<Transaction> findByDateBetween(Timestamp startDate, Timestamp endDate);
    
    List<Transaction> findByTotalGreaterThan(Double amount);
    
    List<Transaction> findByDiscount_DiscountId(String discountId);
}
