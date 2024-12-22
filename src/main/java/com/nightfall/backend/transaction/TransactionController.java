package com.nightfall.backend.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAllWithCustomerDiscountAndItems().stream()
                .map(TransactionDTO::new)
                .collect(Collectors.toList());
    }
}