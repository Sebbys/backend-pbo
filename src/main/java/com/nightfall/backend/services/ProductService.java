package com.nightfall.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightfall.backend.models.Product;
import com.nightfall.backend.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public String getProductNameById(String id) {
        return productRepository.findProductNameById(id);
    }
}

