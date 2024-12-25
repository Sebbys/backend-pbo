package com.nightfall.backend.service;

import com.nightfall.backend.entity.Transaction;
import com.nightfall.backend.entity.TransactionItem;
import com.nightfall.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(UUID transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    public Transaction addTransaction(Transaction transaction) {
        // Calculate total price before saving the transaction
        double totalPrice = 0;
        for (TransactionItem item : transaction.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
            item.setTransaction(transaction); // Set the parent transaction reference
        }

        // Set the total price on the transaction
        transaction.setTotalPrice(totalPrice);

        // Save the transaction along with its items
        return transactionRepository.save(transaction);
    }
}
