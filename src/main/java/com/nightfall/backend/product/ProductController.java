package com.nightfall.backend.product;
import com.nightfall.backend.product.*;
import com.nightfall.backend.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        // Call addProduct method on productService instance
        return productService.addProduct(product);
    }
    
    // Add a simple GET endpoint to verify the controller is working
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Test endpoint is working");
    }

    // Add GetMapping to get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}