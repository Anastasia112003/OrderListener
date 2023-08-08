package com.example.orderlistener.controller;

import com.example.orderlistener.model.Order;
import com.example.orderlistener.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

}
