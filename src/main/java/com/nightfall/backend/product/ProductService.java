package com.nightfall.backend.product;
import com.nightfall.backend.product.Product;
import com.nightfall.backend.product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;

import java.util.List;

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
}