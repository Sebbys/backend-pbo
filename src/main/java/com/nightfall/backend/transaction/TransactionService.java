package com.nightfall.backend.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TransactionService {
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public List<Transaction> findAll() {
        logger.debug("Fetching all transactions");
        return transactionRepository.findAll();
    }

    @Transactional
    public List<Transaction> findAllWithDetails() {
        logger.debug("Fetching all transactions with details");
        return transactionRepository.findAllWithCustomerDiscountAndItems();
    }
}