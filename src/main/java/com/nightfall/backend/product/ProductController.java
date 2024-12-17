package com.nightfall.backend.product;
import com.nightfall.backend.product.*;
import com.nightfall.backend.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    
    // // Add Mapping to update product stock
    // @PutMapping("/{id}/stock")
    // public ResponseEntity<Object> updateProductStock(@PathVariable String id, @RequestBody Map<String, Integer> stockUpdate) {
    //     int newStock = stockUpdate.get("stock");
    //     return productService.updateProductStock(id, newStock);
    // }

    // Add GetMapping to get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // // Add endpoint to handle transaction and decrement product stock
    // @PostMapping("/checkout")
    // public ResponseEntity<Object> handleTransaction(@RequestBody Map<String, Integer> productQuantities) {
    //     return productService.handleTransaction(productQuantities);
    // }
}