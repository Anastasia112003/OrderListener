package com.example.orderlistener.service;

import com.example.orderlistener.model.Order;
import com.example.orderlistener.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderPublisherService orderPublisherService;

    public OrderService(OrderPublisherService orderPublisherService, OrderRepository repository) {
        this.orderPublisherService = orderPublisherService;
        this.repository = repository;
    }


    public Order create(Order order) {
        enrichOrder(order);
        Order regOrder = repository.save(order);
        orderPublisherService.publishEvent(regOrder);
        return regOrder;

    }

    private void enrichOrder(Order order) {
        order.setId(order.getId());
        order.setTime(LocalDateTime.now());
    }
}
