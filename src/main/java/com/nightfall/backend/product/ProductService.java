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
        productRepository.save(product);
        return new ResponseEntity<>("Product is added successfully", HttpStatus.CREATED);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // // Change method signature to use Integer or Long for ID
    // public ResponseEntity<Object> updateProductStock(Integer id, int newStock) {
    //     Product product = productRepository.findById(id).orElse(null);
    //     if (product == null) {
    //         return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    //     }
    //     product.setStock(newStock);
    //     productRepository.save(product);
    //     return new ResponseEntity<>("Product stock updated successfully", HttpStatus.OK);
    // }

    // // Modify this method to use Integer for productId
    // public ResponseEntity<Object> handleTransaction(Map<Integer, Integer> productQuantities) {
    //     for (Map.Entry<Integer, Integer> entry : productQuantities.entrySet()) {
    //         Integer productId = entry.getKey();
    //         int quantity = entry.getValue();
    //         Product product = productRepository.findById(productId).orElse(null);
    //         if (product == null) {
    //             return new ResponseEntity<>("Product not found: " + productId, HttpStatus.NOT_FOUND);
    //         }
    //         if (product.getStock() < quantity) {
    //             return new ResponseEntity<>("Insufficient stock for product: " + productId, HttpStatus.BAD_REQUEST);
    //         }
    //         product.setStock(product.getStock() - quantity);
    //         productRepository.save(product);
    //     }
    //     return new ResponseEntity<>("Transaction completed successfully", HttpStatus.OK);
    // }
}