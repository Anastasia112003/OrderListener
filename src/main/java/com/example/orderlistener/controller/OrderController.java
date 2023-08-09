package com.example.orderlistener.controller;

import com.example.orderlistener.model.Order;
import com.example.orderlistener.service.OrderService;
import com.example.orderlistener.dto.OrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public Order create(@RequestBody OrderDTO orderDTO) {
        return orderService.create(convertToOrder(orderDTO));
    }

    private Order convertToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

}
