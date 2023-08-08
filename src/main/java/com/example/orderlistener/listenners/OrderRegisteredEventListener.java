package com.example.orderlistener.listenners;

import com.example.orderlistener.model.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderRegisteredEventListener {
    @EventListener
    public void sendMessage(Order order) {
        System.out.println("Dear " + order.getUserName() + " Thanks for your order № "
                + order.getId() + " Details: " + order.getDescription());
    }
}
