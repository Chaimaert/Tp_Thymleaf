package com.chai.thymleaf.services;

import com.chai.thymleaf.models.Order;
import com.chai.thymleaf.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {
        Order order = getOrderById(id);
        order.setOrderDate(updatedOrder.getOrderDate());
        order.setTotalAmount(updatedOrder.getTotalAmount());
        order.setClient(updatedOrder.getClient());
        order.setProducts(updatedOrder.getProducts());
        return orderRepository.save(order);
    }
}

