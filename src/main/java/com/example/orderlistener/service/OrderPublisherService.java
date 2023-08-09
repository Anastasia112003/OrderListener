package com.example.orderlistener.service;

import com.example.orderlistener.listenners.OrderRegisteredEvent;
import com.example.orderlistener.model.Order;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisherService {
    private final ApplicationEventPublisher publisher;

    public OrderPublisherService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEvent(final Order order) {
        publisher.publishEvent(new OrderRegisteredEvent(this, order));
    }
}
