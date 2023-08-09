package com.example.orderlistener.listenners;

import com.example.orderlistener.model.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderRegisteredEventListener {
    @EventListener
    public final void sendMessage(final OrderRegisteredEvent event) {
        Order order = event.getOrder();
        System.out.println("Dear " + order.getUserName() + " Thanks for your order № "
                + order.getId() + " Details: " + order.getDescription() + " TIME: " + order.getTime());
    }
}

