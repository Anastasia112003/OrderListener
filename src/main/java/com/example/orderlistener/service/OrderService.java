package com.example.orderlistener.service;

import com.example.orderlistener.listenners.OrderRegisteredEvent;
import com.example.orderlistener.model.Order;
import com.example.orderlistener.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ApplicationEventPublisher publisher;
    private final OrderRepository repository;

    public OrderService(ApplicationEventPublisher publisher, OrderRepository repository) {
        this.publisher = publisher;
        this.repository = repository;
    }

    public void publishEvent(final Order order) {
        publisher.publishEvent(new OrderRegisteredEvent(this, order));
    }

    public Order create(Order order) {
        Order regOrder = repository.save(order);
        publisher.publishEvent(regOrder);
        return regOrder;

    }
}
