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

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return transactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TransactionDTO getTransactionById(@PathVariable UUID id) {
        Transaction transaction = transactionService.getTransactionById(id);
        return convertToDTO(transaction);
    }

    @PostMapping
    public TransactionDTO addTransaction(@RequestBody TransactionDTO transactionDTO) {
        Transaction transaction = convertToEntity(transactionDTO);
        Transaction savedTransaction = transactionService.addTransaction(transaction);
        return convertToDTO(savedTransaction);
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setTransactionId(transaction.getTransactionId());
        dto.setTotalPrice(transaction.getTotalPrice());
        dto.setTransactionDate(transaction.getTransactionDate());
        
        List<TransactionItemDTO> itemsDTO = transaction.getItems().stream()
            .map(item -> {
                TransactionItemDTO itemDTO = new TransactionItemDTO();
                itemDTO.setTransactionItemId(item.getTransactionItemId());
                itemDTO.setPrice(item.getPrice());
                itemDTO.setQuantity(item.getQuantity());
                itemDTO.setProduct(convertToProductDTO(item.getProduct()));
                return itemDTO;
            })
            .collect(Collectors.toList());
        
        dto.setItems(itemsDTO);
        return dto;
    }

    private Transaction convertToEntity(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionDTO.getTransactionId());
        transaction.setTotalPrice(transactionDTO.getTotalPrice());
        transaction.setTransactionDate(transactionDTO.getTransactionDate());

        List<TransactionItem> items = transactionDTO.getItems().stream()
            .map(itemDTO -> {
                TransactionItem item = new TransactionItem();
                item.setTransactionItemId(itemDTO.getTransactionItemId());
                item.setPrice(itemDTO.getPrice());
                item.setQuantity(itemDTO.getQuantity());
                item.setProduct(convertToProductEntity(itemDTO.getProduct()));
                item.setTransaction(transaction);
                return item;
            })
            .collect(Collectors.toList());

        transaction.setItems(items);
        return transaction;
    }

    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        return dto;
    }

    private Product convertToProductEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return product;
    }
}

