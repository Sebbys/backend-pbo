package com.nightfall.backend.discount;
import com.nightfall.backend.discount.InvalidDiscountException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public Optional<Discount> findValidDiscount(String code) {
        return discountRepository.findByCode(code)
            .filter(Discount::isValid);
    }

}
