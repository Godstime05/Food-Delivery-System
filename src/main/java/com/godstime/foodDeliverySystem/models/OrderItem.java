package com.godstime.foodDeliverySystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private double price;

    // getters and setters
}
