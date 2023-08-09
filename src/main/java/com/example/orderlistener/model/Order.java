package com.example.orderlistener.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders", schema = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "description")
    String description;
    @Column(name = "user_name")
    String userName;
    @Column(name="order_time")
    LocalDateTime time;
}
