package com.nightfall.backend.product;
import com.nightfall.backend.product.Product;
import com.nightfall.backend.product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Object> addProduct(Product product) {
        // Call save method on productRepository instance
        productRepository.save(product);
        return new ResponseEntity<>("Product is added successfully", HttpStatus.CREATED);
    }

    // Add method to get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Add method to update product stock
    public ResponseEntity<Object> updateProductStock(Long productId, int newStock) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        product.setStock(newStock);
        productRepository.save(product);
        return new ResponseEntity<>("Product stock updated successfully", HttpStatus.OK);
    }

    // Add method to handle transaction and decrement product stock
    public ResponseEntity<Object> handleTransaction(Map<Long, Integer> productQuantities) {
        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();
            Product product = productRepository.findById(productId).orElse(null);
            if (product == null) {
                return new ResponseEntity<>("Product with ID " + productId + " not found", HttpStatus.NOT_FOUND);
            }
            if (product.getStock() < quantity) {
                return new ResponseEntity<>("Insufficient stock for product with ID " + productId, HttpStatus.BAD_REQUEST);
            }
            product.setStock(product.getStock() - quantity);
            productRepository.save(product);
        }
        return new ResponseEntity<>("Transaction completed successfully", HttpStatus.OK);
    }
}