package com.nightfall.backend.product;

import org.springframework.data.jpa.repository.JpaRepository;
// Add the following import statement
import com.nightfall.backend.product.*
;;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
