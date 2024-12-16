package com.nightfall.backend.transactionproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-products")
public class TransactionProductController {

    @Autowired
    private TransactionProductService transactionProductService;

    @GetMapping
    public ResponseEntity<List<TransactionProduct>> getAllTransactionProducts() {
        return ResponseEntity.ok(transactionProductService.getAllTransactionProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionProduct> getTransactionProductById(@PathVariable String id) {
        TransactionProduct transactionProduct = transactionProductService.getTransactionProductById(id);
        if (transactionProduct != null) {
            return ResponseEntity.ok(transactionProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TransactionProduct> createTransactionProduct(@RequestBody TransactionProduct transactionProduct) {
        return ResponseEntity.ok(transactionProductService.createTransactionProduct(transactionProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionProduct> updateTransactionProduct(
            @PathVariable String id,
            @RequestBody TransactionProduct transactionProduct) {
        TransactionProduct updatedTransactionProduct = transactionProductService.updateTransactionProduct(id, transactionProduct);
        if (updatedTransactionProduct != null) {
            return ResponseEntity.ok(updatedTransactionProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionProduct(@PathVariable String id) {
        if (transactionProductService.deleteTransactionProduct(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
