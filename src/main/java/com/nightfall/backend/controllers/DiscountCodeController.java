package com.nightfall.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import com.nightfall.backend.repository.*;
import com.nightfall.backend.entity.*;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {
    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    @GetMapping
    public List<DiscountCode> getAllDiscountCodes() {
        return discountCodeRepository.findAll();
    }

    @GetMapping("/{id}")
    public DiscountCode getDiscountCodeById(@PathVariable UUID id) {
        return discountCodeRepository.findById(id).orElseThrow(() -> new RuntimeException("Discount code not found"));
    }

    @PostMapping
    public DiscountCode createDiscountCode(@RequestBody DiscountCode discountCode) {
        return discountCodeRepository.save(discountCode);
    }

    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(@PathVariable UUID id, @RequestBody DiscountCode discountCode) {
        discountCode.setId(id);
        return discountCodeRepository.save(discountCode);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscountCode(@PathVariable UUID id) {
        discountCodeRepository.deleteById(id);
    }
}