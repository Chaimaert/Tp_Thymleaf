package com.chai.thymleaf.repositories;

import com.chai.thymleaf.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
