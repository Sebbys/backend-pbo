package com.nightfall.backend.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<Discount> getDiscountById(String discountId) {
        return discountRepository.findById(discountId);
    }

    public Discount saveDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public void deleteDiscount(String discountId) {
        discountRepository.deleteById(discountId);
    }
}
