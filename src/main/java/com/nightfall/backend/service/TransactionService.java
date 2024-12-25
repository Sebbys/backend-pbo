package com.nightfall.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nightfall.backend.service.*;
import com.nightfall.backend.entity.*;
import com.nightfall.backend.repository.*;
import com.nightfall.backend.dto.*;
import java.util.List;
import java.util.UUID;
import java.time.*;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(UUID id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Transactional
    public Transaction addTransaction(TransactionDTO transactionDTO) {
        if (transactionDTO.getItems() == null || transactionDTO.getItems().isEmpty()) {
            throw new IllegalArgumentException("Transaction must contain at least one item");
        }

        Transaction transaction = new Transaction();
        double total = 0.0;

        for (TransactionItemDTO itemDTO : transactionDTO.getItems()) {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            if (product.getQuantity() < itemDTO.getQuantity()) {
                throw new RuntimeException("Insufficient product quantity for " + product.getName());
            }
            total += product.getPrice() * itemDTO.getQuantity();

            // Decrement the product quantity
            product.setQuantity(product.getQuantity() - itemDTO.getQuantity());
            productRepository.save(product);

            TransactionItem item = new TransactionItem();
            item.setProduct(product); // Set product reference
            item.setQuantity(itemDTO.getQuantity());
            item.setTransaction(transaction); // Set reference to parent transaction
            transaction.getItems().add(item); // Add item to the initialized list
        }

        // Apply discount if a valid discount code is provided
        if (transactionDTO.getDiscountCode() != null && !transactionDTO.getDiscountCode().isEmpty()) {
            DiscountCode discountCode = discountCodeRepository.findByCode(transactionDTO.getDiscountCode())
                    .orElseThrow(() -> new RuntimeException("Invalid discount code"));
            if (discountCode.isActive()) {
                double discount = total * (discountCode.getDiscountPercentage() / 100.0);
                total -= discount;
            } else {
                throw new RuntimeException("Inactive discount code");
            }
        }

        transaction.setTotalAmount(total);
        transaction.setTimestamp(LocalDateTime.now()); // Set the current timestamp
        return transactionRepository.save(transaction);
    }
}