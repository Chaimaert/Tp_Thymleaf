package com.chai.thymleaf.services;

import com.chai.thymleaf.models.Client;
import com.chai.thymleaf.models.Order;
import com.chai.thymleaf.repositories.OrderRepository;
import com.chai.thymleaf.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository; // Injected ClientRepository

    public OrderServiceImpl(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        // Ensure the client exists in the database
        Client client = clientRepository.findById(order.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        order.setClient(client);

        // Save the order
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
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
        order.setProducts(updatedOrder.getProducts());
        return orderRepository.save(order);
    }
}


