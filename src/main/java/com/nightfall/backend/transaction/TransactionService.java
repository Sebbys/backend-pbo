package com.nightfall.backend.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    
    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }
    
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    
    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }
    
    public List<Transaction> getTransactionsByCustomerId(String customerId) {
        return transactionRepository.findByCustomer_CustomerId(customerId);
    }
    
    public Double calculateTotalAfterDiscount(Double total, Double discountPercentage) {
        if (discountPercentage == null) return total;
        return total * (1 - discountPercentage/100);
    }
}
