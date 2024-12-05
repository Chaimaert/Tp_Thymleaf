package com.chai.thymleaf.repositories;

import com.chai.thymleaf.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
