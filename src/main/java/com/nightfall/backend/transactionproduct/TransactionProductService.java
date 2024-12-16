package com.nightfall.backend.transactionproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionProductService {
    
    @Autowired
    private TransactionProductRepository transactionProductRepository;

    public List<TransactionProduct> getAllTransactionProducts() {
        return transactionProductRepository.findAll();
    }

    public TransactionProduct getTransactionProductById(String id) {
        Optional<TransactionProduct> transactionProduct = transactionProductRepository.findById(id);
        return transactionProduct.orElse(null);
    }

    public TransactionProduct createTransactionProduct(TransactionProduct transactionProduct) {
        transactionProduct.setId(UUID.randomUUID().toString());
        return transactionProductRepository.save(transactionProduct);
    }

    public TransactionProduct updateTransactionProduct(String id, TransactionProduct transactionProduct) {
        if (transactionProductRepository.existsById(id)) {
            transactionProduct.setId(id);
            return transactionProductRepository.save(transactionProduct);
        }
        return null;
    }

    public boolean deleteTransactionProduct(String id) {
        if (transactionProductRepository.existsById(id)) {
            transactionProductRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
