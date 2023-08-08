package com.example.orderlistener.listenners;

import com.example.orderlistener.model.Order;
import org.springframework.context.ApplicationEvent;


public class OrderRegisteredEvent extends ApplicationEvent {
    private final Order order;

    public OrderRegisteredEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
