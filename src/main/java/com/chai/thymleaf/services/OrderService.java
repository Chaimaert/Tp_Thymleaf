package com.chai.thymleaf.services;

import com.chai.thymleaf.models.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order saveOrder(Order order);
    void deleteOrder(Long id);
    Order updateOrder(Long id, Order updatedOrder);
}

