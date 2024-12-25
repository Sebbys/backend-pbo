package com.nightfall.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nightfall.backend.entity.Transaction;
import com.nightfall.backend.entity.*;
import com.nightfall.backend.service.TransactionService;
import com.nightfall.backend.dto.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable UUID id) {
        return transactionService.getTransactionById(id);
    }


    @PostMapping
    public Transaction addTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.addTransaction(transactionDTO);
    }
}